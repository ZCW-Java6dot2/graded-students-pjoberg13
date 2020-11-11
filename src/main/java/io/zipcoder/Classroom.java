package io.zipcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private Student[] students;

    //nullary constructor
    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Double getAverageExamScores() {
        Double sumOfAverages = 0D;
        for(int i = 0; i < students.length; i++) {
            sumOfAverages += students[i].getAverageScore();
        }
        return sumOfAverages / students.length;
    }

    public void addStudent(Student student) {
        for(int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
                break;
            } else {
                continue;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for(int i = 0; i < students.length; i++) {
            if(students[i].getFirstName().equals((firstName))
            && students[i].getLastName().equals((lastName))) {
                students[i] = null;
                break;
            } else {
                continue;
            }
        }
    }

//    public Student[] alphabetizeStudentList() {
//        Student[] orderedArray = new Student[students.length];
//
//        for(int i = 0; i < students.length - 1; i++) {
//            for(int j = i+1; j < students.length; j++) {
//                if(students[i]) {
//
//                }
//            }
//        }
//    }

    public Student studentScoreLookUp(Double score) {
        for(int i = 0; i < students.length; i++) {
            if(students[i].getAverageScore().equals(score)) {
                return students[i];
            } else {
                continue;
            }
        }
        return null;
    }

    public Student[] getStudentsByScore() {
        Double[] scoresArray = new Double[students.length];
        //Student[] studentsArray = getStudents();;
        for(int i = 0; i < students.length; i++) {
            scoresArray[i] = students[i].getAverageScore();
        }

        Arrays.sort(scoresArray);
        System.out.println(Arrays.toString(scoresArray));

        Student[] studentsByScore = new Student[students.length];
        for(int i = 0; i < scoresArray.length; i++) {
            studentsByScore[i] = studentScoreLookUp(scoresArray[i]);
        }
        System.out.println(Arrays.toString(studentsByScore));
        //Arrays.sort(studentsByScore);
        return studentsByScore;
    }

    public Student[] getStudents() {
        return students;
    }

    public Map<String, Character> getGradeBook() {
        Map<String, Character> gradeBook = new HashMap<>();

        int count, percent;

        for(int i = 0; i < students.length; i++) {
            count = 0;
            for(int j = 0; j < students.length; j++) {
                if(students[i].getAverageScore() > students[j].getAverageScore()) {
                    count++;
                }
            }
            percent = (count * 100) / (students.length - 1);
            if(percent > 89) {
                gradeBook.put(students[i].toString(), 'A');
            } else if(percent <= 89 && percent > 70) {
                gradeBook.put(students[i].toString(), 'B');
            } else if(percent <= 70 && percent > 49) {
                gradeBook.put(students[i].toString(), 'C');
            } else if(percent <= 49 && percent > 11) {
                gradeBook.put(students[i].toString(), 'D');
            } else {
                gradeBook.put(students[i].toString(), 'F');
            }
        }

        return gradeBook;
    }
}
