package Sem.Sem_4.Zadacha_06;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Ivan", 5),
                new Student("Maria", 6),
                new Student("Georgi", 4),
                new Student("Anna", 6));

        List<Student> excellentStudents = students.stream()
                .filter(student -> student.grade == 6)
                .collect(Collectors.toList());

        List<String> names = excellentStudents.stream()
                .map(student -> student.name)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Uchenici s otsenka 6:");
        for (Student student : excellentStudents) {
            System.out.println(student.name + " - " + student.grade);
        }

        System.out.println("Imena po azbuchen red: " + names);
    }
}
