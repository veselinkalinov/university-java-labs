package Study.Session_4.Student_Managment_HashMap;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private final Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) throws DuplicateStudentException {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        int id = student.getId();
        if (students.containsKey(id)) {
            throw new DuplicateStudentException("Student ID already exists: " + id);
        }

        students.put(id, student);
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException("Student ID not found: " + id);
        }

        return students.get(id);
    }

    public void removeStudentById(int id) throws StudentNotFoundException {
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException("Student ID not found: " + id);
        }

        students.remove(id);
    }

    public boolean containsStudentById(int id) {
        return students.containsKey(id);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Student register is empty.");
            return;
        }

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey()
                    + ", Name: " + entry.getValue().getName());
        }
    }

    public int getStudentCount() {
        return students.size();
    }
}
