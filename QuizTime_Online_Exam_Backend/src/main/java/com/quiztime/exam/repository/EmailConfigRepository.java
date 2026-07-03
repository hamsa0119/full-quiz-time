package com.quiztime.exam.repository;

import com.quiztime.exam.model.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmailConfigRepository extends JpaRepository<EmailConfig, Long> {
    Optional<EmailConfig> findByConfigName(String configName);
}
