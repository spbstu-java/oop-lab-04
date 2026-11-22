import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethods {

    public static double getAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static List<String> addPrefixAndUppercase(List<String> strings) {
        return strings.stream().map(String::toUpperCase)
                .map(s -> "*new*" + s).collect(Collectors.toList());
    }

    public static List<Integer> getSquaresOfUniqueNumbers(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return numbers.stream().filter(n -> counts.get(n) == 1)
                .map(n -> n * n).collect(Collectors.toList());
    }

    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream().reduce((first, second) -> second).orElseThrow();
    }

    public static int getSumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers).filter(n -> n % 2 == 0).sum();
    }

    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .peek(s -> Objects.requireNonNull(s, "Строка не должна быть null"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));
    }
}
