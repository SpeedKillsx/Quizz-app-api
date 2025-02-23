package com.speedkillsx.quizzapp.service;

import com.speedkillsx.quizzapp.entity.Quizz;
import com.speedkillsx.quizzapp.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizService {

    private final QuizRepository quizRepository;
    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<Quizz> createQuizz(String title, String category, Integer numberQuestions) {
        log.info("Creating Quizz ....");
        try{
            log.info("Creating Quizz");
            Quizz quizz = new Quizz();
            quizz.setTitle(title);
            quizz.setCategory(category);
            quizz.setNumberQuestions(numberQuestions);
            quizz.setQuestion(quizRepository.getQuestionsForQuizz(category, numberQuestions));
            log.info("Questions for quizz charged: " + quizz.getQuestion());
            this.quizRepository.save(quizz);
            log.info("Quizz created");
            return new ResponseEntity<Quizz>(quizz, HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ResponseEntity<Quizz>( HttpStatus.BAD_REQUEST);
    }

    public Quizz getQuizz( String title){
        log.info("Showing quizzes : "+this.quizRepository.getQuizzByTitle(title));
        return  this.quizRepository.getQuizzByTitle(title);
    }
}
