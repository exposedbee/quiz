package fr.epita.Services;

import fr.epita.datamodel.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.inject.Inject;

public class QuestionJPADAO {

	@Inject
    SessionFactory sf;



    public void create(Question question) {
        System.out.println("Question="+question.getQuestionTitle());
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();

    }

}