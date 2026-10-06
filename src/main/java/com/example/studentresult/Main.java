package com.example.studentresult;

public class Main {

    public static void main(String[] args) {
        StudentResult student = new StudentResult("Asha Kumar", 85, 92, 78);

        System.out.println("Student Result Management System");
        System.out.println("--------------------------------");
        System.out.println("Student Name : " + student.getName());
        System.out.println("Total Marks  : " + student.calculateTotal());
        System.out.printf("Average      : %.2f%n", student.calculateAverage());
        System.out.println("Grade        : " + student.calculateGrade());
    }
}
