package Study.Session_5.Students_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(103, "Georgi", 5.50));
        students.add(new Student(101, "Ivan", 5.50));
        students.add(new Student(104, "Petar", 4.00));
        students.add(new Student(102, "Maria", 6.00));

        System.out.println("Before sorting:");

        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students);

        System.out.println("\nAfter sorting by ID:");

        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(new StudentGradeComparator());

        System.out.println("\nSorted by grade:");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
