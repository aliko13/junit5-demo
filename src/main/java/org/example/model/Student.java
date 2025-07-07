package org.example.model;

import java.util.List;

public class Student {
    private final String name;
    private final List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        if (grades.stream().anyMatch(g -> g < 0 || g > 100)) {
            throw new IllegalArgumentException("Invalid grade: must be between 0–100");
        }
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return grades.stream().mapToInt(i -> i).average().orElse(0.0);
    }
}

