package com.quiztime.exam.service;

import com.quiztime.exam.dto.PasswordChangeRequest;
import com.quiztime.exam.dto.ProfileUpdateRequest;
import java.util.Map;

public interface AdminService {
    Map<String, Object> getProfile(String username);

    Map<String, Object> updateProfile(String currentUsername, ProfileUpdateRequest request);

    void changePassword(String username, PasswordChangeRequest request);

    boolean verifyPassword(String username, String password);
}
