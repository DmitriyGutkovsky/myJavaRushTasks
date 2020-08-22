package com.javarush.task.task29.task2909.human;

import java.util.*;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        return students.stream()
                .filter(student -> student.getAverageGrade() == value)
                .findFirst()
                .get();
    }

    public Student getStudentWithMaxAverageGrade() {
        return Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

    public Student getStudentWithMinAverageGrade(){
        return students.stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade))
                .get();
    }

    public void expel(Student student){
        students.remove(student);
    }
}