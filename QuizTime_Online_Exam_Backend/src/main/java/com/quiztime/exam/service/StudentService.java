package com.quiztime.exam.service;

import com.quiztime.exam.dto.BulkAssignRequest;
import com.quiztime.exam.dto.StatusUpdateRequest;
import com.quiztime.exam.dto.StudentRequest;
import com.quiztime.exam.dto.StudentResponse;
import java.util.List;

public interface StudentService {
    StudentResponse addStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest request);

    StudentResponse updateStudentStatus(Long id, StatusUpdateRequest request);

    void bulkAssign(BulkAssignRequest request);

    void deleteStudent(Long id);
}
