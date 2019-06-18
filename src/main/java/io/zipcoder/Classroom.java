package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }
    public Double getAverageExamScore() {
        Double sum = 0.0;
        Double avg;
        for(int i = 0; i < students.length; i++) {
            sum = sum + students[i].getAverageExamScore();
        }
        avg = sum / students.length;

        return avg;
    }
    public void addStudent(Student student) {
        List<Student>  students = new ArrayList<>();
        if(this.students != null) {
            students = new ArrayList<>(Arrays.asList(this.students));
        }
        students.add(student);
        this.students = students.toArray(new Student[]{});



    }
    public void removeStudent(String firstName, String lastName) {
    List<Student> students = new ArrayList<>();
    if(this.students !=null) {
        students = new ArrayList<>(Arrays.asList(this.students));
    }
    for(Student student : students) {
        if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
            students.remove(student);
            break;
        }
    }
    this.students = students.toArray(new Student[]{});

    }
    public Student[] getStudentsByScore() {
        Student[] students = this.students.clone();
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getAverageExamScore() < students[j + 1].getAverageExamScore()) {
                    Student student = students[i];
                    students[j] = students[j + 1];
                    students[j + 1] = student;
                }
                else if(students[j].getAverageExamScore() == students[j+1].getAverageExamScore()) {
                    if(students[j].getFirstName().compareTo(students[j+1].getFirstName())>0) {
                        Student student = students[i];
                        students[j] = students[j + 1];
                        students[j + 1] = student;
                    }
                }
            }
        }
        return students;
    }
    public  Map<Student, String > getGradeBook() {

        // Create Map with Student as Key and Value as String
        Map<Student, String > hm = new HashMap<>();

        // Sort students array based on AverageExamScore
        Student[] students = getStudentsByScore();

        // Percentile Index for 90  = Math.round(numberOfStudents * 0.9)
        int percentile90Index = (int) Math.round(students.length * 0.1);
        int percentile70Index = (int) Math.round(students.length * 0.29);
        int percentile50Index = (int) Math.round(students.length * 0.5);
        int percentile10Index = (int) Math.round(students.length * 0.89);
        int percentile0Index = students.length;

        for(int i = 0; i< percentile90Index ; i++) {
            hm.put(students[i],"A");
        }
        for(int i = percentile90Index; i < percentile70Index; i++) {
            hm.put(students[i],"B");

        }
        for(int i = percentile70Index; i< percentile50Index ; i++) {
            hm.put(students[i],"C");
        }
        for (int i = percentile50Index; i < percentile10Index; i++) {
            hm.put(students[i], "D");
        }
        for (int i = percentile10Index; i < percentile0Index; i++) {
            hm.put(students[i], "F");
        }


        // return Map
        return hm;
    }

}
