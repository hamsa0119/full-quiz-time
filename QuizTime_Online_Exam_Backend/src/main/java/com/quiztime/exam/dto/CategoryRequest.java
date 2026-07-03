package com.quiztime.exam.dto;

import lombok.Data;

@Data
public class CategoryRequest {
    private String name;
    private String description;
    private String color;
    private String status;
    private Integer questionCount;
}
