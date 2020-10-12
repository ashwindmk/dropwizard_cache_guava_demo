package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.Student;

public interface StudentRepository {
    Student getById(Long id);
}
