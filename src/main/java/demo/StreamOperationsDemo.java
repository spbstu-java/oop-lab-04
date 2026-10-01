package demo;

import streams.StreamOperations;

import java.util.List;

/** Console entry point: prints example results of each Stream API method. */
public final class StreamOperationsDemo {

    public static void main(String[] args) {
        System.out.println("---- Stream API Demo ----");

        System.out.println("\naverage([2, 4, 6, 8]) = "
                + StreamOperations.average(List.of(2, 4, 6, 8)));

        System.out.println("\nupperCaseWithPrefix([\"hello\", \"world\"]) = "
                + StreamOperations.upperCaseWithPrefix(List.of("hello", "world")));

        System.out.println("\nsquaresOfUniqueElements([1, 2, 2, 3, 3, 3, 4]) = "
                + StreamOperations.squaresOfUniqueElements(List.of(1, 2, 2, 3, 3, 3, 4)));

        System.out.println("\nlastElement([\"a\", \"b\", \"c\"]) = "
                + StreamOperations.lastElement(List.of("a", "b", "c")));

        System.out.println("\nsumOfEvenNumbers([1, 2, 3, 4, 5, 6]) = "
                + StreamOperations.sumOfEvenNumbers(new int[] {1, 2, 3, 4, 5, 6}));

        System.out.println("\nfirstCharacterIndex([\"cat\", \"dog\", \"emu\"]) = "
                + StreamOperations.firstCharacterIndex(List.of("cat", "dog", "emu")));
    }
}