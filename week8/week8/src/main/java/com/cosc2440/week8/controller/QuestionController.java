package com.cosc2440.week8.controller;

import com.cosc2440.week8.model.Question;
import com.cosc2440.week8.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // "create" request does not need to specify id for question and answer object
    @RequestMapping(path = "/questions", method = RequestMethod.POST)
    public int addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @RequestMapping(path = "/questions", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // "update" request requires specifying id for question and answer object needed to be updated
    // otherwise, if the question has no id, the request will cause error
    // if question has id but answer has no id, new answer in question will be created
    @RequestMapping(path = "/questions", method = RequestMethod.PUT)
    public int updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }
}
