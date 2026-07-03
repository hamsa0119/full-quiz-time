package com.quiztime.exam.controller;

import com.quiztime.exam.dto.ExamPortalQuestionResponse;
import com.quiztime.exam.dto.ExamEntryValidationRequest;
import com.quiztime.exam.model.Test;
import com.quiztime.exam.service.ExamEntryService;
import com.quiztime.exam.service.ExamPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exam-portal")
public class ExamPortalController {

    @Autowired
    private ExamPortalService examPortalService;

    @Autowired
    private ExamEntryService examEntryService;

    @GetMapping("/verify/{code}")
    public ResponseEntity<?> verifyCode(@PathVariable String code) {
        try {
            Test test = examPortalService.verifyCode(code);
            return ResponseEntity.ok(test);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("/verify/{code}")
    public ResponseEntity<?> verifyCodePost(@PathVariable String code, @RequestBody ExamEntryValidationRequest request) {
        request.setCode(code);
        return ResponseEntity.ok(examEntryService.validateCode(request));
    }

    @GetMapping("/resume-state/{code}")
    public ResponseEntity<?> getResumeState(@PathVariable String code) {
        return ResponseEntity.ok(examPortalService.getResumeState(code));
    }

    @GetMapping("/questions/{code}")
    public ResponseEntity<?> getQuestionsForTest(@PathVariable String code) {
        try {
            List<ExamPortalQuestionResponse> questions = examPortalService.getQuestionsForTest(code);
            return ResponseEntity.ok(questions);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}
