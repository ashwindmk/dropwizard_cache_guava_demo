package com.ashwin.java.domain.service;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;

import javax.inject.Inject;

public class StudentService {
    private StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getById(Long id) {
        if (id != null) {
            return this.studentRepository.getById(id);
        }
        return null;
    }
}
