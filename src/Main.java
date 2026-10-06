import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3);
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "cat");

        System.out.println("average: " + StreamMethods.average(numbers));
        System.out.println("upper: " + StreamMethods.upperWithPrefix(strings));
        System.out.println("uniqueSquares: " + StreamMethods.uniqueSquares(numbers));
        System.out.println("last: " + StreamMethods.lastElement(numbers));
        System.out.println("sumEven: " + StreamMethods.sumEven(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("sumEven empty: " + StreamMethods.sumEven(new int[]{}));
        System.out.println("toMap: " + StreamMethods.toMap(strings));

        try {
            StreamMethods.lastElement(new ArrayList<String>());
        } catch (NoSuchElementException e) {
            System.out.println("empty collection: " + e);
        }
    }
}
