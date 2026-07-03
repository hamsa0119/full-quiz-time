package com.quiztime.exam.dto;

import lombok.Data;

@Data
public class CategoryConfigRequest {
    private Long categoryId;
    private String categoryName;
    private Integer questionCount;
}
