package com.kastro.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
(любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
которые посещают этот курс.

 */
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Маша", Arrays.asList(new Course("Обработка фотографий"), new Course("Автоматизация"),
                new Course("Devops"))));
        students.add(new Student("Таня", Arrays.asList(new Course("Agile"), new Course("Английский язык"),
                new Course("Фотошоп"), new Course("Тестирование"))));
        students.add(new Student("Саша", Arrays.asList(new Course("Танцы"), new Course("Agile"))));
        students.add(new Student("Надя", Arrays.asList(new Course("Фотошоп"), new Course("Вокал"),
                new Course("Автоматизация"), new Course("Тестирование"), new Course("Английский язык"))));

        printSetOfCourses(students);
        printTop3StudentsWithMaxCourses(students);
        printStudentsByCourse(students, new Course("Автоматизация"));
    }

    private static void printSetOfCourses(List<Student> students) {
        System.out.println(students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList()));
    }

    private static void printTop3StudentsWithMaxCourses(List<Student> students) {
        System.out.println(students.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList()));
    }

    private static void printStudentsByCourse(List<Student> students, Course course) {
        System.out.println(students.stream()
                .filter(student -> student.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
