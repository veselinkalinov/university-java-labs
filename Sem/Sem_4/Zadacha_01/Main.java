package Sem.Sem_4.Zadacha_01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 8, 12, 3, 6);

        List<Integer> evenNumbers = list.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(evenNumbers);
    }
}
