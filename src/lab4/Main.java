package lab4;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<String> words = List.of("apple", "banana", "cherry", "avocado");
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] odd = {1, 3, 5};

        System.out.println("numbers: " + numbers);
        System.out.println("average: " + StreamProcessor.findAverage(numbers));
        System.out.println("squares of unique: " + StreamProcessor.singleOccurrenceSquares(numbers));
        System.out.println("last: " + StreamProcessor.findLast(numbers));
        System.out.println();

        System.out.println("words: " + words);
        System.out.println("upper with prefix: " + StreamProcessor.formatUpperWithPrefix(words));
        System.out.println("to map: " + StreamProcessor.mapByFirstChar(words));
        System.out.println();

        System.out.println("sum of even " + Arrays.toString(array) + ": " + StreamProcessor.evenNumbersSum(array));
        System.out.println("sum of even " + Arrays.toString(odd) + ": " + StreamProcessor.evenNumbersSum(odd));

        try {
            StreamProcessor.findLast(Set.of());
        } catch (NoSuchElementException e) {
            System.out.println("last of empty: " + e.getMessage());
        }
    }
}
