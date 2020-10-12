package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;

import javax.inject.Inject;
import javax.inject.Named;

public class StudentRepositoryImpl implements StudentRepository {
    private StudentSource studentCacheSource;

    @Inject
    public StudentRepositoryImpl(@Named("student-cache-source") StudentSource studentSource) {
        this.studentCacheSource = studentSource;
    }

    @Override
    public Student getById(Long id) {
        return studentCacheSource.getById(id);
    }
}
