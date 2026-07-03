package com.quiztime.exam.dto;

import lombok.Data;

@Data
public class ProfileUpdateRequest {
    private String username;
    private String name;
    private String email;
}
