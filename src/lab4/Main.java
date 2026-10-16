package lab4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42, 8, 4);
        List<String> words = List.of("java", "stream", "api", "лямбда");
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] odd = {1, 3, 5};

        System.out.println("Список чисел: " + numbers);
        System.out.println("1. Среднее: " + StreamMethods.average(numbers));

        System.out.println("Список строк: " + words);
        System.out.println("2. Верхний регистр с префиксом: " + StreamMethods.toUpperCaseWithPrefix(words));

        System.out.println("3. Квадраты элементов, встречающихся один раз: " + StreamMethods.squaresOfUnique(numbers));

        System.out.println("4. Последний элемент списка: " + StreamMethods.last(numbers));
        System.out.println("   Последний элемент множества: " + StreamMethods.last(new LinkedHashSet<>(words)));
        try {
            StreamMethods.last(List.of());
        } catch (NoSuchElementException e) {
            System.out.println("   Пустая коллекция: " + e.getMessage());
        }

        System.out.println("5. Сумма чётных в " + Arrays.toString(array) + ": " + StreamMethods.sumOfEven(array));
        System.out.println("   Сумма чётных в " + Arrays.toString(odd) + ": " + StreamMethods.sumOfEven(odd));

        List<String> forMap = List.of("apple", "banana", "cherry", "avocado", "x");
        System.out.println("6. Map из " + forMap + ": " + StreamMethods.toFirstCharMap(forMap));
    }
}
