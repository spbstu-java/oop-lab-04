package ru.spbstu.lab4;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        List<Integer> places = List.of(1, 1, 2, 1, 5);
        System.out.println("Места Ферстаппена " + places);
        System.out.println("Среднее место: " + StreamMethods.average(places));
        try {
            StreamMethods.average(List.of());
        } catch (NoSuchElementException e) {
            System.out.println("Среднее пустого списка: " + e.getMessage());
        }
        System.out.println();

        List<String> drivers = List.of("verstappen", "norris", "leclerc");
        System.out.println("Пилоты " + drivers);
        System.out.println("С префиксом: " + StreamMethods.toUpperCaseWithPrefix(drivers));
        System.out.println();

        List<Integer> numbers = List.of(1, 4, 16, 1, 44, 4, 81);
        System.out.println("Номера болидов " + numbers);
        System.out.println("Квадраты тех, что встречаются один раз: " + StreamMethods.squaresOfUnique(numbers));
        System.out.println();

        List<String> tracks = List.of("Бахрейн", "Джидда", "Мельбурн", "Сузука");
        System.out.println("Трассы " + tracks);
        System.out.println("Последняя: " + StreamMethods.lastElement(tracks));
        try {
            StreamMethods.lastElement(List.of());
        } catch (NoSuchElementException e) {
            System.out.println("Последний элемент пустой коллекции: " + e.getMessage());
        }
        System.out.println();

        int[] laps = {1, 4, 16, 44, 63, 81};
        int[] oddLaps = {1, 33, 81};
        System.out.println("Сумма чётных в " + Arrays.toString(laps) + ": " + StreamMethods.sumOfEven(laps));
        System.out.println("Сумма чётных в " + Arrays.toString(oddLaps) + ": " + StreamMethods.sumOfEven(oddLaps));
        System.out.println();

        List<String> names = List.of("Verstappen", "Norris", "Leclerc", "Hamilton", "Hulkenberg", "");
        System.out.println("Фамилии " + names);
        System.out.println("Map: " + StreamMethods.toMap(names));
    }
}
