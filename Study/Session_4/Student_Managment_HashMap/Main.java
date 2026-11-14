package Study.Session_4.Student_Managment_HashMap;

public class Main {
    public static void main(String[] args)
            throws DuplicateStudentException, StudentNotFoundException {
        StudentManager manager = new StudentManager();

        check(manager.getStudentCount() == 0, "Empty register");
        check(!manager.containsStudentById(999), "Unknown ID is absent");

        Student ivan = new Student(101, "Ivan");
        Student georgi = new Student(103, "Georgi");
        manager.addStudent(ivan);
        manager.addStudent(georgi);

        check(manager.getStudentCount() == 2, "Two students added");
        check(manager.containsStudentById(101), "Existing ID is found");
        check(manager.findStudentById(103) == georgi, "Find by ID 103");

        boolean duplicateCaught = false;
        try {
            manager.addStudent(new Student(101, "Petar"));
        } catch (DuplicateStudentException e) {
            duplicateCaught = true;
            System.out.println("Expected exception: " + e.getMessage());
        }
        check(duplicateCaught, "Duplicate ID is rejected");
        check(manager.getStudentCount() == 2, "Duplicate does not change size");
        check(manager.findStudentById(101) == ivan, "Original student is preserved");

        System.out.println("\nCurrent register (HashMap order is not guaranteed):");
        manager.displayStudents();

        boolean missingFindCaught = false;
        try {
            manager.findStudentById(999);
        } catch (StudentNotFoundException e) {
            missingFindCaught = true;
            System.out.println("Expected exception: " + e.getMessage());
        }
        check(missingFindCaught, "Unknown ID cannot be found");

        manager.removeStudentById(101);
        check(!manager.containsStudentById(101), "ID 101 was removed");
        check(manager.getStudentCount() == 1, "One student remains");

        boolean missingRemoveCaught = false;
        try {
            manager.removeStudentById(101);
        } catch (StudentNotFoundException e) {
            missingRemoveCaught = true;
            System.out.println("Expected exception: " + e.getMessage());
        }
        check(missingRemoveCaught, "Removing missing ID is rejected");
        check(manager.containsStudentById(103), "Georgi remains in register");

        manager.removeStudentById(103);
        check(manager.getStudentCount() == 0, "Register is empty after removals");
        manager.displayStudents();

        System.out.println("\nAll tests passed.");
    }

    private static void check(boolean condition, String description) {
        if (!condition) {
            throw new AssertionError("FAILED: " + description);
        }
        System.out.println("PASS: " + description);
    }
}
