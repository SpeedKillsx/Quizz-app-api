CREATE TABLE QUIZZ (
    id SERIAL primary key ,
    category varchar NOT NULL,
    number_questions integer NOT NULL,
    title varchar NOT NULL
);

CREATE TABLE quizz_question(
   quizz_id INT NOT NULL,
   question_id INT NOT NULL,
   PRIMARY KEY (quizz_id, question_id),
   FOREIGN KEY (quizz_id) REFERENCES QUIZZ(id) ON DELETE CASCADE,
   FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);