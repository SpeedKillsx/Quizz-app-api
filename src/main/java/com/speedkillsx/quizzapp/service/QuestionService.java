package com.speedkillsx.quizzapp.service;

import com.speedkillsx.quizzapp.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.speedkillsx.quizzapp.repository.QuestionRepository;

import java.util.List;

@Service
@Slf4j
public class QuestionService {

    private final QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions(){
        log.info("Start loading the questions");
        return this.questionRepository.findAll();
    }
    public void addQuestion(Question question){
        log.info("Start adding the question");
        this.questionRepository.save(question);


    }

    public List<Question> getQuestionsByCategory(String category){
        log.info("Start loading the questions by category");
        return this.questionRepository.findAllByCategory(category);
    }

}
