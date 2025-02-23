package com.speedkillsx.quizzapp.resource;

import com.speedkillsx.quizzapp.entity.Quizz;
import com.speedkillsx.quizzapp.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quiz")
@Slf4j
public class QuizResource {
    private final QuizService quizService;

    @Autowired
    public QuizResource(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public void newQuiz(@RequestParam("title") String title, @RequestParam("category") String category, @RequestParam("numberOfQuestions") Integer numberOfQuestions ) {
        this.quizService.createQuizz(title, category, numberOfQuestions);
    }

    @GetMapping("/show/{title}")
    public ResponseEntity<Quizz> showQuiz(@PathVariable String title){
        return new ResponseEntity<Quizz>(this.quizService.getQuizz(title),HttpStatus.OK);
    }

    @GetMapping("/score")
    public  Integer scoreQuiz(@RequestParam("quizz") Integer quizzId, @RequestParam("answers") List<String> answers){
        Quizz quizz = this.quizService.getQuizzById(quizzId);
        return this.quizService.computeScore(quizz, answers);

    }
}
