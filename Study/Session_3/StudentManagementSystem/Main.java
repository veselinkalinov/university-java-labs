package Study.Session_3.StudentManagementSystem;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student1 = new Student("Ivan", 5.50, 101);
        Student student2 = new Student("Maria", 6.00, 102);
        Student student3 = new Student("Georgi", 4.75, 103);
        Student replacement = new Student("Petar", 5.75, 104);

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        Student found = manager.findStudentById(102);
        if (found != null) {
            System.out.println(found.getName());
        } else {
            System.out.println("Student not found");
        }

        Student missing = manager.findStudentById(999);
        if (missing != null) {
            System.out.println(missing.getName());
        } else {
            System.out.println("Student not found");
        }

        manager.printStudents();
        manager.removeStudentById(102);
        manager.printStudents();

        System.out.println(manager.removeStudentById(999));

        manager.replaceStudentById(101, replacement);
        manager.printStudents();
    }
}
