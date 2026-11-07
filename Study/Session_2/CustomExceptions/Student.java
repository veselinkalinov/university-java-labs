package Study.Session_2.CustomExceptions;

public class Student {
    private double grade;

    public Student(double grade) throws InvalidGradeException {
        setGrade(grade);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) throws InvalidGradeException {
        if (grade >= 2.0 && grade <= 6.0) {
            this.grade = grade;
        } else {
            throw new InvalidGradeException("Invalid Grade");
        }
    }
}
