package com.quiztime.exam.service;

import com.quiztime.exam.dto.EmailConfigRequest;
import com.quiztime.exam.dto.SmtpTestResponse;
import com.quiztime.exam.model.EmailConfig;

public interface EmailConfigService {
    EmailConfig getEmailConfig();

    EmailConfig saveEmailConfig(EmailConfigRequest request);

    SmtpTestResponse testSmtpConnection(EmailConfigRequest request);
}
