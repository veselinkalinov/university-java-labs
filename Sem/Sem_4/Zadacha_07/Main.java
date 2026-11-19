package Sem.Sem_4.Zadacha_07;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 8, 15, 16, 23, 42);

        double average = nums.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);

        System.out.println("Sredna stoinost: " + average);
    }
}
