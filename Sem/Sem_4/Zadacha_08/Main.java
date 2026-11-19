package Sem.Sem_4.Zadacha_08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item("Hrana", 5.50),
                new Item("Tehnika", 900),
                new Item("Hrana", 2.20),
                new Item("Knigi", 18),
                new Item("Tehnika", 120));

        Map<String, List<Item>> groupedItems = items.stream()
                .collect(Collectors.groupingBy(item -> item.category));

        for (String category : groupedItems.keySet()) {
            System.out.println("Kategoriya: " + category);
            for (Item item : groupedItems.get(category)) {
                System.out.println("Cena: " + item.price);
            }
        }
    }
}
