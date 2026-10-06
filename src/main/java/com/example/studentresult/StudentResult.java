package com.example.studentresult;

/**
 * Holds one student's marks in three subjects and works out
 * the total, the average and the grade.
 */
public class StudentResult {

    private final String name;
    private final int mark1;
    private final int mark2;
    private final int mark3;

    public StudentResult(String name, int mark1, int mark2, int mark3) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty");
        }
        checkMark(mark1);
        checkMark(mark2);
        checkMark(mark3);

        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    private static void checkMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100, but got " + mark);
        }
    }

    public String getName() {
        return name;
    }

    /** Sum of the three subject marks (0 to 300). */
    public int calculateTotal() {
        return mark1 + mark2 + mark3;
    }

    /** Average of the three subject marks (0.0 to 100.0). */
    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    /** Grade based on the average mark. */
    public String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
