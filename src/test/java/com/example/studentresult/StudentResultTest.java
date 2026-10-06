package com.example.studentresult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StudentResultTest {

    @Test
    void calculateTotalAddsAllThreeMarks() {
        StudentResult student = new StudentResult("Asha", 85, 92, 78);

        assertEquals(255, student.calculateTotal());
    }

    @Test
    void calculateAverageDividesTotalByThree() {
        StudentResult student = new StudentResult("Asha", 85, 92, 78);

        assertEquals(85.0, student.calculateAverage(), 0.001);
    }

    @Test
    void calculateAverageKeepsDecimalPart() {
        StudentResult student = new StudentResult("Ravi", 70, 71, 71);

        assertEquals(70.667, student.calculateAverage(), 0.001);
    }

    @Test
    void calculateGradeReturnsCorrectGradeForEachRange() {
        assertEquals("A+", new StudentResult("S1", 95, 95, 95).calculateGrade());
        assertEquals("A", new StudentResult("S2", 85, 85, 85).calculateGrade());
        assertEquals("B", new StudentResult("S3", 75, 75, 75).calculateGrade());
        assertEquals("C", new StudentResult("S4", 65, 65, 65).calculateGrade());
        assertEquals("D", new StudentResult("S5", 55, 55, 55).calculateGrade());
        assertEquals("F", new StudentResult("S6", 40, 40, 40).calculateGrade());
    }

    @Test
    void calculateGradeHandlesBoundaryValues() {
        assertEquals("A+", new StudentResult("S1", 90, 90, 90).calculateGrade());
        assertEquals("A", new StudentResult("S2", 89, 89, 89).calculateGrade());
        assertEquals("D", new StudentResult("S3", 50, 50, 50).calculateGrade());
        assertEquals("F", new StudentResult("S4", 49, 49, 49).calculateGrade());
    }

    @Test
    void constructorRejectsInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> new StudentResult("Asha", 101, 50, 50));
        assertThrows(IllegalArgumentException.class, () -> new StudentResult("Asha", 50, -1, 50));
        assertThrows(IllegalArgumentException.class, () -> new StudentResult("", 50, 50, 50));
    }
}
