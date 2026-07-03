package com.quiztime.exam.controller;

import com.quiztime.exam.dto.EmailConfigRequest;
import com.quiztime.exam.dto.SmtpTestResponse;
import com.quiztime.exam.model.EmailConfig;
import com.quiztime.exam.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings/email")
public class EmailConfigController {

    @Autowired
    private EmailConfigService emailConfigService;

    @GetMapping
    public ResponseEntity<EmailConfig> getEmailConfig() {
        return ResponseEntity.ok(emailConfigService.getEmailConfig());
    }

    @PostMapping
    public ResponseEntity<EmailConfig> saveEmailConfig(@RequestBody EmailConfigRequest request) {
        return ResponseEntity.ok(emailConfigService.saveEmailConfig(request));
    }

    @PostMapping("/test")
    public ResponseEntity<SmtpTestResponse> testConnection(@RequestBody EmailConfigRequest request) {
        return ResponseEntity.ok(emailConfigService.testSmtpConnection(request));
    }
}
