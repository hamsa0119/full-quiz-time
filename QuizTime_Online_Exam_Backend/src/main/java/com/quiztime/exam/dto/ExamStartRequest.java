package com.quiztime.exam.dto;

import lombok.Data;

@Data
public class ExamStartRequest {
    private String code;
    private Long studentId;
    private String sessionToken;
}
