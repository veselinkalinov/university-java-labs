package Sem.Sem_4.Zadacha_05;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 1, 2, 3, 5, 3, 6, 6, 6, 2);

        List<Integer> uniqueNumbers = nums.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNumbers);
    }
}
