package Study.Session_2.CustomExceptions;

public class Main {
    public static void main(String args[]) {
        try {
            Student student_1 = new Student(5.50);

            System.out.println("Student 1 Grade: " + student_1.getGrade());

            student_1.setGrade(6.0);
            System.out.println("\nStudent 1 Grade: " + student_1.getGrade());

            try {
                student_1.setGrade(7.0);
            } catch (InvalidGradeException e) {
                System.out.println(e.getMessage());

            }
            System.out.println("\nStudent 1 Grade: " + student_1.getGrade());
            try {
                Student student_2 = new Student(1.50);
                System.out.println("\nStudent 2 Grade: " + student_2.getGrade());
            } catch (InvalidGradeException e) {
                System.out.println(e.getMessage());

            }
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());

        }
    }
}
