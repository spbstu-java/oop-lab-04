package lab04;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Методы лабораторной работы 4. Каждый метод реализован исключительно через Stream API.
 */
public final class StreamTasks {

    private StreamTasks() {
    }

    /**
     * Возвращает среднее значение списка целых чисел.
     *
     * @param numbers список целых чисел
     * @return среднее арифметическое или {@code 0.0}, если список пуст
     */
    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    /**
     * Приводит все строки списка к верхнему регистру и добавляет префикс {@code _new_}.
     *
     * @param strings исходный список строк
     * @return новый список преобразованных строк
     */
    public static List<String> toUpperCaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .toList();
    }

    /**
     * Возвращает квадраты элементов, которые встречаются в списке ровно один раз.
     *
     * @param numbers исходный список
     * @return список квадратов уникальных по частоте элементов в порядке первого появления
     */
    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        Map<Integer, Long> frequencies = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return numbers.stream()
                .filter(n -> frequencies.get(n) == 1L)
                .map(n -> n * n)
                .toList();
    }

    /**
     * Возвращает последний элемент коллекции.
     *
     * @param collection входная коллекция
     * @param <T>        тип элементов
     * @return последний элемент
     * @throws NoSuchElementException если коллекция пуста
     */
    public static <T> T last(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    /**
     * Возвращает сумму чётных чисел массива или {@code 0}, если чётных чисел нет.
     *
     * @param numbers массив целых чисел
     * @return сумма чётных элементов
     */
    public static int sumOfEven(int[] numbers) {
        return IntStream.of(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    /**
     * Преобразует строки в {@code Map}: первый символ — ключ, остаток строки — значение.
     * При совпадении ключа сохраняется значение более поздней строки.
     *
     * @param strings исходный список непустых строк
     * @return карта «первый символ → остаток строки»
     */
    public static Map<Character, String> toCharMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (existing, replacement) -> replacement));
    }
}
