package com.speedkillsx.quizzapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Quizz {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @SequenceGenerator(
            name = "quiz_sequence",
            allocationSize = 1
    )
    private int id;
    private String title;
    private String category;
    private int numberQuestions;
    @ManyToMany
    private List<Question> question;

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public int getNumberQuestions() {
        return numberQuestions;
    }

    public void setNumberQuestions(int numberQuestions) {
        this.numberQuestions = numberQuestions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
