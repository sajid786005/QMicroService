package com.quiz.service.impl;

import com.quiz.Repositories.QuizRepository;
import com.quiz.entities.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;


   QuizServiceImpl(QuizRepository  quizRepository,QuestionClient questionClient){
       this.quizRepository = quizRepository;
       this.questionClient = questionClient;
   }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
       List<Quiz> quizzes = quizRepository.findAll();

    List<Quiz> newQuiizList = quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
           return  quiz;
       }).collect(Collectors.toList());

        return newQuiizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
