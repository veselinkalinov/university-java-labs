package Study.Session_3.StudentManagementSystem;

public class Student {
    private String name;
    private double grade;
    private int id;

    public Student(String name, double grade, int id) {
        this.name = name;
        this.grade = grade;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
