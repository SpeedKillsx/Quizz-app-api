package com.speedkillsx.quizzapp.resource;

import com.speedkillsx.quizzapp.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.speedkillsx.quizzapp.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("api/v1/question")
@Slf4j
public class QuestionResource {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/AllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        log.info("Start loading the questions");
        try {
            log.info("getAllQuestions start");
            return new ResponseEntity<>(this.questionService.getAllQuestions(), HttpStatus.OK);

        }catch (Exception e){
                log.error(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/questions/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return  this.questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public void insertQuestion(@RequestBody Question question){
        log.info("insertQuestion start");
        this.questionService.addQuestion(question);
    }
}
