package com.question.Controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public  QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return  questionService.create(question);
    }

    @GetMapping("/{questionid}")
    public List<Question> getAll(){
        return  questionService.get();
    }

    @GetMapping("/{questionId}")
    public  Question getAll(@PathVariable Long questionId){
        return  questionService.getOne(questionId);
    }
    @GetMapping("/quiz/{quizId}")
    public  List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return  questionService.getQuestionOfQuiz(quizId);

    }



}
