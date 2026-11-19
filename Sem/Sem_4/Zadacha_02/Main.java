package Sem.Sem_4.Zadacha_02;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("ivan", "Maria", "pesho");

        List<String> upperNames = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upperNames);
    }
}
