import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);
        System.out.println("1. Среднее значение: " + StreamMethods.getAverage(numbers));

        List<String> words = List.of("java", "stream api", "intellij");
        System.out.println("2. Строки с префиксом: " + StreamMethods.addPrefixAndUppercase(words));

        List<Integer> repeated = List.of(2, 3, 2, 4, 5, 3, 6);
        System.out.println("3. Квадраты уникальных элементов: "
                + StreamMethods.getSquaresOfUniqueNumbers(repeated));

        List<String> names = List.of("Анна", "Иван", "Олег");
        System.out.println("4. Последний элемент: " + StreamMethods.getLastElement(names));

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("5. Сумма четных чисел: " + StreamMethods.getSumOfEvenNumbers(array));

        List<String> mapWords = List.of("apple", "ant", "banana", "berry", "cat");
        Map<Character, String> map = StreamMethods.convertToMap(mapWords);
        System.out.println("6. Результат Map: " + map);
    }
}
