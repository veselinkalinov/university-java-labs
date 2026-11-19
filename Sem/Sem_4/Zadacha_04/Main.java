package Sem.Sem_4.Zadacha_04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 9, 1, 5, 2);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedNumbers);
    }
}
