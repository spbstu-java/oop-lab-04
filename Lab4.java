import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab4 {
  public static void main() {
    List<Integer> numbers = Arrays.asList(4, 2, 10, -2, 7, 7, 3, 5, 8, 1);
    List<String> strings = Arrays.asList("Double-Bogie", "Par", "Birdie", "Eagle"); // Bogie

    System.out.println("Среднее значение: " + average(numbers));
    System.out.println("Строки с префиксом: " + transformStrings(strings));
    System.out.println("Квадраты уникальных элементов: " + uniqueSquares(numbers));
    System.out.println("Последний элемент: " + last(numbers));
    System.out.println("Сумма чётных чисел: " + sumEven(new int[] { -4, 1, 2, 9, 3, 10 }));
    System.out.println("Map из строк: " + stringsToMap(strings));
  }

  /** метод, возвращающий среднее значение списка целых чисел; */
  public static double average(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElseThrow(() -> new NoSuchElementException("Cannot average an empty list"));
  }

  /**
   * метод, приводящий все строки в списке в верхний регистр и добавляющий к ним
   * префикс «_new_»;
   */
  public static List<String> transformStrings(List<String> strings) {
    return strings.stream()
        .map(value -> "_new_" + value.toUpperCase(Locale.ROOT))
        .collect(Collectors.toList());
  }

  /**
   * метод, возвращающий список квадратов всех встречающихся только один раз
   * элементов списка;
   */
  public static List<Integer> uniqueSquares(List<Integer> numbers) {
    Map<Integer, Long> frequencies = numbers.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return numbers.stream()
        .filter(number -> frequencies.get(number) == 1L)
        .map(number -> number * number)
        .collect(Collectors.toList());
  }

  /**
   * метод, принимающий на вход коллекцию и возвращающий ее последний элемент
   * или кидающий исключение, если коллекция пуста;
   */
  public static <T> T last(Collection<T> elements) {
    return elements.stream()
        .reduce((previous, current) -> current)
        .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
  }

  /**
   * метод, принимающий на вход массив целых чисел, возвращающий сумму чётных
   * чисел
   * или 0, если чётных чисел нет;
   */
  public static int sumEven(int[] numbers) {
    return Arrays.stream(numbers)
        .filter(number -> number % 2 == 0)
        .sum();
  }

  /**
   * метод, преобразовывающий все строки в списке в Map,
   * где первый символ – ключ, оставшиеся – значение;
   */
  public static Map<Character, String> stringsToMap(List<String> strings) {
    return strings.stream()
        .collect(Collectors.toMap(value -> value.charAt(0), value -> value.substring(1)));
  }
}
