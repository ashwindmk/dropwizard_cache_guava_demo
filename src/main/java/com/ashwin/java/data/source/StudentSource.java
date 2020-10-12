package com.ashwin.java.data.source;

import com.ashwin.java.domain.model.Student;

public interface StudentSource {
    Student getById(Long id);
}
