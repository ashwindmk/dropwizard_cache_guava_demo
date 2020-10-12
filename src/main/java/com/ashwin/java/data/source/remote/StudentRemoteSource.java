package com.ashwin.java.data.source.remote;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.domain.model.Student;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class StudentRemoteSource implements StudentSource {
    private List<Student> students;

    @Inject
    public StudentRemoteSource() {
        students = new ArrayList<Student>();
        students.add(new Student(1L, "Alice"));
        students.add(new Student(2L, "Bob"));
        students.add(new Student(3L, "Clara"));
        students.add(new Student(4L, "Daniel"));
    }

    @Override
    public Student getById(Long id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
