package Study.Session_7.UniqueStudents;

public class Student {
    private final int id;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student other = (Student) o;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Student{id=");
        text.append(this.id);

        text.append(", name=");
        text.append(this.name);

        text.append(" ,grade=");
        text.append(this.grade);

        text.append("}");

        String text_string = text.toString();
        return text_string;

    }
}
