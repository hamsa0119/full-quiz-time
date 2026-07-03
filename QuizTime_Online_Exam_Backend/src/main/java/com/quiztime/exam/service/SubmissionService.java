package com.quiztime.exam.service;

import com.quiztime.exam.dto.SubmissionRequest;
import com.quiztime.exam.dto.SubmissionResponse;
import com.quiztime.exam.model.Submission;
import java.util.List;
import java.util.Map;

public interface SubmissionService {
    List<Submission> getAllSubmissions();

    Map<String, Object> getSubmissionStats();

    SubmissionResponse processSubmission(SubmissionRequest request);
}
