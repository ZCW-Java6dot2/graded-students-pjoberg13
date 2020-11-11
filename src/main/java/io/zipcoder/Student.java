package io.zipcoder;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        for(int i = 0; i < examScores.length; i++) {
            this.examScores.add(examScores[i]);
        }
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examIndex, double newScore) {
        examScores.set(examIndex, newScore);
    }

    public Double getAverageScore() {
        //get sum of exam scores divide by number of exams taken
        double scoresSum = 0;
        for(int i = 0; i < examScores.size(); i++) {
            scoresSum += examScores.get(i);
        }
        return scoresSum/examScores.size();
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }
}
