public class Main {
    public static void main(String[] args) {

        System.out.println(maxOfThree(5, 12, 8)); // 12
        System.out.println(maxOfThree(-3, -7, -1)); // -1
        System.out.println(maxOfThree(4, 4, 4)); // 4
        System.out.println(maxOfThree(7, 7, 2)); // 7
        System.out.println(maxOfThree(2, 10, 10)); // 10

        System.out.println("");

        System.out.println(minOfThree(5, 12, 8)); // 5
        System.out.println(minOfThree(-3, -7, -1)); // -7
        System.out.println(minOfThree(4, 4, 4)); // 4
        System.out.println(minOfThree(7, 7, 2)); // 2
        System.out.println(minOfThree(2, 10, 10)); // 2

        System.out.println("");

        System.out.println(firstMultipleOfThree(4, 10)); // 6
        System.out.println(firstMultipleOfThree(7, 8)); // -1
        System.out.println(firstMultipleOfThree(-5, -2)); // -3
        System.out.println(firstMultipleOfThree(3, 3)); // 3
    }

    public static int maxOfThree(int a, int b, int c) {
        int max = a;
        if (a >= b && a >= c) {
            return max;
        } else if (b >= c && b >= a) {
            max = b;
        } else {
            max = c;
        }

        return max;

    }

    public static int minOfThree(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= c && b <= a) {
            return b;
        } else {
            return c;
        }
    }

    public static int firstMultipleOfThree(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 3 == 0) {
                return i;
            }
        }
        return -1;
    }

}
