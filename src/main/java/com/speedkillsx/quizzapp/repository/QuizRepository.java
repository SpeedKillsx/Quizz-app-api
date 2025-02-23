package com.speedkillsx.quizzapp.repository;

import com.speedkillsx.quizzapp.entity.Question;
import com.speedkillsx.quizzapp.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quizz, Integer> {
    @Query(value = "SELECT * FROM Question q where q.category = :category ORDER BY RANDOM()" +
            "LIMIT :numberofQuestions",
            nativeQuery = true
    )
    List<Question> getQuestionsForQuizz(String category, Integer numberofQuestions);

    Quizz getQuizzByTitle(String title);
}
