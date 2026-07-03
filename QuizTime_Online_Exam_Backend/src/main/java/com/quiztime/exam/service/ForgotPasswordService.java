package com.quiztime.exam.service;

import com.quiztime.exam.dto.ForgotPasswordRequest;

public interface ForgotPasswordService {
    void requestOtp(String email);

    void verifyOtp(String email, String otp);

    void resetPassword(ForgotPasswordRequest request);
}
