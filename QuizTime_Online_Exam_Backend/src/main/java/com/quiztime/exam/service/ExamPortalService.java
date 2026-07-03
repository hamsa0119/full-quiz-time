package com.quiztime.exam.service;

import com.quiztime.exam.dto.ExamPortalQuestionResponse;
import com.quiztime.exam.model.Test;
import java.util.List;
import java.util.Map;

public interface ExamPortalService {
    Test verifyCode(String code);

    Map<String, Object> getResumeState(String code);

    List<ExamPortalQuestionResponse> getQuestionsForTest(String code);
}
