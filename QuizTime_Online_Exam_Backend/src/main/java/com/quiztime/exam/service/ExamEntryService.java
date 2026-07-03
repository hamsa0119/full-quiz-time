package com.quiztime.exam.service;

import com.quiztime.exam.dto.ExamCompleteRequest;
import com.quiztime.exam.dto.ExamEntryResponse;
import com.quiztime.exam.dto.ExamEntryValidationRequest;
import com.quiztime.exam.dto.ExamStartRequest;

public interface ExamEntryService {
    ExamEntryResponse validateCode(ExamEntryValidationRequest request);

    ExamEntryResponse startExam(ExamStartRequest request);

    void completeExam(ExamCompleteRequest request);
}
