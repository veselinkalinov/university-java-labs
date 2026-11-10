package Study.Session_3.StudentManagementSystem;

import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    public StudentManager() {
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(
                    "--- Student ---\n" + student.getName() + "\n" + student.getGrade() + "\n" + student.getId());
        }
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                return students.get(i);
            }
        }

        return null;
    }

    public boolean replaceStudentById(int id, Student replacement) {
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                students.set(i, replacement);
                return true;
            }
        }
        return false;
    }
}
