package streams;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42, 8, 15);

        System.out.println("Среднее: " + StreamOps.averageOf(numbers));
        try {
            StreamOps.averageOf(List.of());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("С префиксом: " + StreamOps.upperWithPrefix(List.of("java", "stream", "api")));

        System.out.println("Квадраты одиночных: " + StreamOps.squaresOfUnique(numbers));

        System.out.println("Последний элемент: " + StreamOps.lastElement(List.of("")));
        try {
            StreamOps.lastElement(List.of());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Сумма чётных: " + StreamOps.evenSum(new int[] {1, 3, 4, 7, 10}));
        System.out.println("Сумма чётных без чётных: " + StreamOps.evenSum(new int[] {1, 3, 5}));

        System.out.println("Map: " + StreamOps.indexByFirstChar(List.of("cherry", "banana", "apple", "", "avocado")));
    }
}
