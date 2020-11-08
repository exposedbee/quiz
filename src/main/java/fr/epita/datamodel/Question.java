package fr.epita.datamodel;

import javax.persistence.*;
import java.util.Arrays;



@Entity
@Table(name="QUESTIONS")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer questionId;

    private String questionTitle;
    private String[] topics ;
    private Integer difficulty;


    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public String[] getTopics() {
        return topics;
    }
    public void setTopics(String[] topics) {
        this.topics = topics;
    }
    public Integer getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Question [questionTitle=" + questionTitle + ", topics=" + Arrays.toString(topics) + ", difficulty="
                + difficulty + "]";
    }


}