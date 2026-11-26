package Study.Session_7.UniqueStudents;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        Student student_1 = new Student(101, "Ivan", 5.50);
        Student student_2 = new Student(102, "Maria", 6.00);
        Student student_3 = new Student(101, "Petar", 4.50);
        Student student_4 = new Student(103, "Georgi", 5.75);

        Set<Student> students = new HashSet<>();

        System.out.println(students.add(student_1));
        System.out.println(students.add(student_2));
        System.out.println(students.add(student_3));
        System.out.println(students.add(student_4));
        System.out.println(students.size());
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nTest 1:");
        System.out.println(student_1.equals(student_3));
        System.out.println(student_1.hashCode() == student_3.hashCode());

        System.out.println("\nTest 2:");
        System.out.println(student_1.equals(null));

        System.out.println("\nTest 3:");
        System.out.println(student_1.equals("Ivan"));

        System.out.println("\nTest 4:");
        Student student_test_1 = new Student(101, "Ivan", 5.55);
        Student student_test_2 = new Student(101, "Gosho", 3.50);
        Student student_test_3 = new Student(101, "Mario", 4.50);

        Set<Student> test_students = new HashSet<>();
        System.out.println(test_students.add(student_test_1));
        System.out.println(test_students.add(student_test_2));
        System.out.println(test_students.add(student_test_3));
        System.out.println(test_students.size());

        System.out.println("\nTest 5:");
        System.out.println(students.contains(student_test_3));

    }
}
