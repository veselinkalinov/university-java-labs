import java.util.Scanner;

public class ExamResults {
    public static void readResults(String[] fn, int[] grades, Scanner scanner) {
        System.out.println("Vuvedete fn i ocenka: ");

        for (int i = 0; i < grades.length; i++) {
            fn[i] = scanner.next();
            grades[i] = scanner.nextInt();
        }
    }

    public static void printResults(String[] fn, int[] grades) {
        System.out.println("\nRezultati ot izpita:");

        for (int i = 0; i < grades.length; i++) {
            System.out.println("FN: " + fn[i] + ", grade: " + grades[i]);
        }
    }

    public static void printFailedStudents(String[] fn, int[] grades) {
        System.out.println("FN na skusani studenti: ");
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == 2) {
                System.out.println("FN: " + fn[i]);
            }
        }
        System.out.println();
    }

    public static int countFailedStudents(String[] fn, int[] grades) {
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == 2) {
                count++;
            }
        }
        return count;
    }

    public static double avgGrade(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        return (double) sum / grades.length;
    }

    public static void printTopStudents(String[] fn, int[] grades) {
        int max = grades[0];

        for (int i = 1; i < grades.length; i++) {
            if (max < grades[i]) {
                max = grades[i];
            }
        }
        System.out.println("Nai - visoka ocenka: " + max);

        System.out.println("FN na studenti s nai - visoka ocenka: ");
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == max) {
                System.out.println("FN: " + fn[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vuvedete broi studenti: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Nevaliden broi studenti");
            scanner.close();
            return;
        }

        String[] fn = new String[n];
        int[] grades = new int[n];

        readResults(fn, grades, scanner);
        printResults(fn, grades);
        System.out.println();

        int count = countFailedStudents(fn, grades);
        System.out.println("Broi skusani studenti: " + count);

        printFailedStudents(fn, grades);
        System.out.println();

        double avgGrade = avgGrade(grades);
        System.out.println("Sreden uspeh na grupata: " + avgGrade);

        printTopStudents(fn, grades);

        scanner.close();
    }
}
