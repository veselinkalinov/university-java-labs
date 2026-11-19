package Sem.Sem_4.Zadacha_03;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Sofia", "apple", "Computer", "Tree", "Orange");

        List<String> result = words.stream()
                .filter(word -> word.length() > 4 && Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
