void main()
{
    var numbers = List.of(1, 2, 3, 4, 5);
    IO.println("- метод, возвращающий среднее значение списка целых чисел: "
            + MyStreams.average(numbers));

    var words = List.of("один", "два", "три", "четыре", "пять", "овавава");
    IO.println("\n- метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «new»: "
            + MyStreams.upperWithPrefix(words));
    
    var numbersWithDuplicate = List.of(1, 2, 2, 3, 4, 4, 5);
    IO.println("\n- метод, возвращающий список квадратов всех встречающихся только один раз элементов списка: "
            + MyStreams.squaresOfUniqueNumbers(numbersWithDuplicate));


    IO.println("\n- метод, принимающий на вход коллекцию и возвращающий ее последний элемент или кидающий исключение, если коллекция пуста: "
            + MyStreams.lastElementOfCollection(words));
    try {
        MyStreams.lastElementOfCollection(Collections.emptyList());
    } catch (NoSuchElementException e) {
        IO.println("вариант, кидающий исключение: " + e.getMessage());
    }
    
    IO.println("\n- метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел или 0, если чётных чисел нет: "
            + MyStreams.sumOfEvenNumbers(new int[]{1, 2, 3, 4, 5}));
    IO.println("вариант, когда четных нет: "
            + MyStreams.sumOfEvenNumbers(new int[]{1, 3, 5}));
    
    IO.println("\n- метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение: "
            + MyStreams.toMapByFirstSymbol(words));
}
