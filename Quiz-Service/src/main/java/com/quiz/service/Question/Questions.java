package com.quiz.service.Question;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

    private  Long questionId;
    private  String question;
    private Long quizId;
}
