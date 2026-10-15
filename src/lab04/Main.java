package lab04;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * Демонстрация методов лабораторной работы 4, реализованных только через Stream API.
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        forceConsoleUtf8();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Среднее " + numbers + " = " + StreamTasks.average(numbers));
        System.out.println("Среднее пустого списка = " + StreamTasks.average(List.of()));

        List<String> words = List.of("hello", "stream", "api");
        System.out.println("Строки с префиксом: " + StreamTasks.toUpperCaseWithPrefix(words));

        List<Integer> withDuplicates = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("Квадраты уникальных " + withDuplicates + " = "
                + StreamTasks.squaresOfUnique(withDuplicates));

        System.out.println("Последний элемент " + numbers + " = " + StreamTasks.last(numbers));
        try {
            StreamTasks.last(List.of());
        } catch (Exception e) {
            System.out.println("Пустая коллекция: " + e.getClass().getSimpleName() + " — " + e.getMessage());
        }

        int[] values = {1, 2, 3, 4, 5, 6};
        System.out.println("Сумма чётных {1, 2, 3, 4, 5, 6} = " + StreamTasks.sumOfEven(values));
        System.out.println("Сумма чётных {1, 3, 5} = " + StreamTasks.sumOfEven(new int[]{1, 3, 5}));

        List<String> pairs = List.of("apple", "banana", "avocado", "berry");
        Map<Character, String> map = StreamTasks.toCharMap(pairs);
        System.out.println("Карта строк " + pairs + " = " + map);
    }

    /**
     * Принудительно переводит {@code System.out} на UTF-8, чтобы кириллица
     * корректно отображалась независимо от кодовой страницы консоли Windows.
     */
    private static void forceConsoleUtf8() {
        try {
            java.io.Console console = System.console();
            String charset = (console != null)
                    ? console.charset().name()
                    : StandardCharsets.UTF_8.name();

            PrintStream utf8 = new PrintStream(
                    new FileOutputStream(FileDescriptor.out), true, charset);
            System.setOut(utf8);
        } catch (UnsupportedEncodingException ignored) {
            // Недостижимая ветка: все кодовые страницы консоли поддерживаются.
        }
    }
}
