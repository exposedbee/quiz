package fr.epita.services.test;

import fr.epita.datamodel.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSpringInjection {

    @Inject
    @Named("questionSample")
    Question qSample;


    @Inject
    @Named("datasourcePGSQL")
    DataSource ds;

    @Inject
    @Named("firstQuery")
    private String injectedString;

    @Test
    public void testStringFromSpring() {

        Assert.assertNotNull(injectedString);
        System.out.println(injectedString);

    }


    @Test
    public void testDS() throws SQLException {

        Assert.assertNotNull(ds);
        Connection connection = ds.getConnection();

        String schema = connection.getSchema();
        Assert.assertEquals("public", schema.toLowerCase());
        System.out.println(schema);

    }

    @Test
    public void testSimpleDataModelInjection() {
        Question question = new Question();
        question.setQuestionTitle("What is Java?");
        Assert.assertEquals(question.toString(), qSample.toString());
        System.out.println("original handmade question : " + qSample);
        System.out.println("injected question (spring) : " + question);
    }

}
