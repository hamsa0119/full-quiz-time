package com.quiztime.exam.service;

import com.quiztime.exam.dto.LoginRequest;
import com.quiztime.exam.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
