package fr.epita.services.test;

import fr.epita.Services.QuestionJPADAO;
import fr.epita.datamodel.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestQuestionJPADAO {

    @Inject
    QuestionJPADAO dao;


    @Test
    public void testCreation() {
        //given

        Question question = new Question();
        question.setQuestionTitle("What is Java?");
        question.setDifficulty(2);

        //when
        dao.create(question);

        //todo check result
    }



}