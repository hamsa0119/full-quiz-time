package com.quiztime.exam.repository;

import com.quiztime.exam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByNic(String nic);

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByNicAndIsDeletedFalse(String nic);
    
    boolean existsByNicAndIdNotAndIsDeletedFalse(String nic, Long id);

    java.util.List<Student> findAllByIsDeletedFalse();
}
