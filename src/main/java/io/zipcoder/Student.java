package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Double> examScores;


    public Student(String firstName,String lastName,Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
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

    //public ArrayList<Double> getExamScores() {
      //  return examScores;
    //}

    //public void setExamScores(ArrayList<Double> examScores) {
      //  this.examScores = examScores;
    //}
    public int getNumberOfExamsTaken() {

        return examScores.size();  //total number of exams taken by this student
    }
    public String getExamScores() {
        String str = "";
        for(int i = 0; i < examScores.size(); i++) {
            str += "Exam " +(i+1) +" -> " +examScores.get(i).intValue()+"\n";

        }
        return str;

    }
    public void addExamScore(double examScore) {

        examScores.add(examScore);
    }
    public void setExamScore(int examNumber, double newScore) {

        examScores.set(examNumber - 1,newScore);
    }
    public Double getAverageExamScore() {
        Double sum = 0.0;
        Double d;
        for (int i = 0; i < examScores.size(); i++) {
            sum += examScores.get(i);

        }
        d = sum / examScores.size();
        return d;
    }
    public String toString() {
        return "Student Name: "+this.firstName +" " +this.lastName +"\n" + "Average Score: " +this.getAverageExamScore() +"\nExam Scores:\n" +this.getExamScores();
    }
}
