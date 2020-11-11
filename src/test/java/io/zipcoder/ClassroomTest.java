package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getAverageExamScoresTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        Classroom classroom = new Classroom();
        Double[] examScores = {100.0, 95.0, 120.,};
        Student s1 = new Student("Peter", "Oberg", examScores);
        Student s2 = new Student("Ham", "Oberg", examScores);

        classroom.addStudent(s1);
        classroom.addStudent(s2);
        Student[] postEnrollment = classroom.getStudents();
        System.out.println(Arrays.toString(postEnrollment));

        classroom.removeStudent("Peter", "Oberg");
        System.out.println(Arrays.toString(postEnrollment));
    }

    @Test
    public void getStudentsByScoreTest() {
        Classroom classroom = new Classroom(2);
        Double[] examScores1 = {100.0, 95.0, 120.,};
        Double[] examScores2 = {150.0, 105.0, 110.,};
        Student s1 = new Student("Peter", "Oberg", examScores1);
        Student s2 = new Student("Ham", "Oberg", examScores2);

        classroom.addStudent(s2);
        classroom.addStudent(s1);
        System.out.println(Arrays.toString(classroom.getStudents()));

        //System.out.println(Arrays.toString(classroom.getStudents()));

        Student[] studentsByExamScores = classroom.getStudentsByScore();
        System.out.println(Arrays.toString(studentsByExamScores));
    }

    @Test
    public void getGradeBookTest() {
        Classroom classroom = new Classroom(2);
        Double[] examScores1 = {100.0, 95.0, 120.,};
        Double[] examScores2 = {150.0, 105.0, 110.,};
        Student s1 = new Student("Peter", "Oberg", examScores1);
        Student s2 = new Student("Ham", "Oberg", examScores2);

        classroom.addStudent(s2);
        classroom.addStudent(s1);

        System.out.println(String.valueOf(classroom.getGradeBook()));
    }
}
