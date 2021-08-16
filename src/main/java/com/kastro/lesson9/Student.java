package com.kastro.lesson9;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\nСтудент - '" + name + "'. Записан на курсы: " + courses;
    }

    @Override
    public int compareTo(Student o) {
        return o.getCourses().size() - this.courses.size();
    }
}
