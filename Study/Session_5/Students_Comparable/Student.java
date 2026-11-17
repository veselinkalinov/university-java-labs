package Study.Session_5.Students_Comparable;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.id, this.id);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + grade;
    }
}
