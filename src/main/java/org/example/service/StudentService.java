package org.example.service;

import org.example.model.Student;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    public List<Student> findTopStudents(List<Student> students) {
        return students.stream()
                .filter(s -> s.getAverage() >= 80)
                .collect(Collectors.toList());
    }

    public List<Student> findFailingStudents(List<Student> students) {
        return students.stream()
                .filter(s -> s.getAverage() < 50)
                .collect(Collectors.toList());
    }
}
