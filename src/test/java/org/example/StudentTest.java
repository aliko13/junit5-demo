package org.example;

import org.example.model.Student;
import org.example.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("🎓 Student Service Tests")
class StudentTest {

    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService();
    }

    @Test
    @DisplayName("Should return top students with avg >= 80")
    void testFindTopStudents() {
        var students = List.of(
                new Student("Ali", List.of(95, 85, 100)),
                new Student("Mira", List.of(60, 70)),
                new Student("Samir", List.of(40, 45))
        );
        var top = service.findTopStudents(students);
        assertEquals(1, top.size());
        assertEquals("Ali", top.get(0).getName());
    }

    @Test
    @DisplayName("Should throw exception for invalid grade")
    void testStudentInvalidGrade() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("Error", List.of(110, 70)));
    }

    @Test
    @DisplayName("Grouped assertion for average")
    void testAverageCalculation() {
        Student s = new Student("Sara", List.of(60, 70, 80));
        assertAll("Average check",
                () -> assertTrue(s.getAverage() > 65),
                () -> assertFalse(s.getAverage() < 60),
                () -> assertEquals(70.0, s.getAverage(), 0.001)
        );
    }

    @Nested
    @DisplayName("🧪 Parameterized Average Tests")
    class ParameterizedAverageTests {

        @ParameterizedTest(name = "Average of {1}, {2}, {3} should be {0}")
        @CsvSource({
                "70.0, 60, 70, 80",
                "90.0, 100, 90, 80",
                "50.0, 40, 50, 60"
        })
        void testAverageFromGrades(double expectedAvg, String g1, String g2, String g3) {
            List<Integer> grades = List.of(
                    Integer.parseInt(g1),
                    Integer.parseInt(g2),
                    Integer.parseInt(g3)
            );
            Student s = new Student("Param", grades);
            assertEquals(expectedAvg, s.getAverage(), 0.001);
        }

        @ParameterizedTest
        @ValueSource(ints = {-10, -1, 101, 200})
        @DisplayName("Should reject invalid grade values")
        void testInvalidGrades(int invalidGrade) {
            List<Integer> grades = List.of(50, invalidGrade);
            assertThrows(IllegalArgumentException.class, () -> new Student("Test", grades));
        }
    }
}
