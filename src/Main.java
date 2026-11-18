import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {

    // метод, возвращающий среднее значение списка целых чисел;
    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «new»
    public static List<String> upperCaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // метод, возвращающий список квадратов всех встречающихся только один раз элементов списка;
    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey() * entry.getKey())
                .collect(Collectors.toList());
    }

    // метод, принимающий на вход коллекцию и возвращающий ее последний элемент или кидающий исключение, если коллекция пуста;
    public static <T> T lastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    // метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет;
    public static int sumEven(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    // метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение;
    public static Map<Character, String> stringsToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1)
                ));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5);

        System.out.println("Average: " + average(numbers));

        List<String> strings = Arrays.asList("php", "java", "1c");
        System.out.println("upperCaseWithPrefix: " + upperCaseWithPrefix(strings));

        System.out.println("squaresOfUnique: " + squaresOfUnique(numbers));

        System.out.println("lastElement: " + lastElement(numbers));

        int[] array = {1, 2, 2, 3, 5, 6};
        System.out.println("sumEven: " + sumEven(array));

        List<String> strings2 = Arrays.asList("car", "aircraft", "boat");
        System.out.println("stringsToMap: " + stringsToMap(strings2));
    }
}
