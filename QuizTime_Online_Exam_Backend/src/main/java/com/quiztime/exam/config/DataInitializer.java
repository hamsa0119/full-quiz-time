package com.quiztime.exam.config;

import com.quiztime.exam.model.Admin;
import com.quiztime.exam.model.EmailConfig;
import com.quiztime.exam.repository.EmailConfigRepository;
import com.quiztime.exam.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EmailConfigRepository emailConfigRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${SMTP_USER:}")
    private String smtpUser;

    @Value("${SMTP_PASS:}")
    private String smtpPass;

    @Value("${SMTP_HOST:smtp.gmail.com}")
    private String smtpHost;

    @Value("${SMTP_PORT:587}")
    private String smtpPort;

    @Override
    public void run(String... args) throws Exception {
        if (adminRepository.count() == 0) {
            Admin defaultAdmin = new Admin();
            defaultAdmin.setUsername("admin_user");
            defaultAdmin.setEmail("admin@quiztime.com");
            defaultAdmin.setPassword(passwordEncoder.encode("admin123"));
            defaultAdmin.setName("System Admin");
            adminRepository.save(defaultAdmin);
            System.out.println("Default admin account created: admin_user / admin123");
        }

        // Initialize Email Configuration if missing
        if (emailConfigRepository.findByConfigName("PRIMARY").isEmpty()) {
            EmailConfig config = new EmailConfig();
            config.setConfigName("PRIMARY");
            config.setSmtpServer(smtpHost);
            config.setSmtpPort(smtpPort);
            config.setUsername(smtpUser.isEmpty() ? "YOUR_EMAIL@gmail.com" : smtpUser);
            config.setPassword(smtpPass.isEmpty() ? "" : smtpPass);
            config.setSenderEmail(smtpUser.isEmpty() ? "YOUR_EMAIL@gmail.com" : smtpUser);
            config.setSenderName("QuizTime Portal");
            emailConfigRepository.save(config);
            System.out.println("Default Email Configuration initialized. Please update SMTP credentials in Admin Settings.");
        }
    }
}
