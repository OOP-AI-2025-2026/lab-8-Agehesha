package ua.opnu;

import ua.opnu.tuples.GenericTwoTuple;
import ua.opnu.tuples.GenericThreeTuple;

import java.util.Arrays;

public class Main {
public static void main(String[] args) {
System.out.println("=== MyOptional demo ===");
MyOptional<Integer> empty = new MyOptional<>();
System.out.println("empty: " + empty);
System.out.println("empty.isPresent(): " + empty.isPresent());
System.out.println("empty.orElse(42): " + empty.orElse(42));
try {
System.out.println("empty.get(): " + empty.get());
} catch (IllegalStateException ex) {
System.out.println("empty.get() threw: " + ex.getMessage());
}
MyOptional<String> present = new MyOptional<>("Hello");
System.out.println("present: " + present);
System.out.println("present.get(): " + present.get());

    System.out.println("\n=== BookData sort demo ===");
    BookData[] books = new BookData[] {
            new BookData("Algorithms", "Sedgewick", 2, 9.0),     // 4.50
            new BookData("Data Structures", "Goodrich", 3, 12.0), // 4.00
            new BookData("Zero Reviews", "Nobody", 0, 0.0),       // 0.00 (edge case)
            new BookData("AI Handbook", "Ng", 2, 9.0)             // 4.50, tie by title
    };
    Printer printer = new Printer();
    System.out.println("Before sort:");
    printer.printArray(books);
    Arrays.sort(books);
    System.out.println("After sort (desc by rating, then title):");
    printer.printArray(books);

    System.out.println("\n=== Printer demo ===");
    Integer[] nums = {1, 2, 3, 4};
    String[] words = {"one", "two", "three", "four"};
    printer.printArray(nums);
    printer.printArray(words);

    System.out.println("\n=== ArraysUtil.filter demo (length > 3) ===");
    MyPredicate<String> longerThan3 = s -> s != null && s.length() > 3;
    String[] filtered = ArraysUtil.filter(words, longerThan3);
    printer.printArray(filtered);
    System.out.println("Filtered size: " + filtered.length);

    System.out.println("\n=== ArraysUtil.contains demo ===");
    Integer[] withNull = {1, null, 3};
    System.out.println("contains null: " + ArraysUtil.contains(withNull, null));
    System.out.println("contains 2: " + ArraysUtil.contains(withNull, 2));

    BookData probe = new BookData("AI Handbook", "X", 2, 9.0); // same title & rating -> compareTo == 0
    System.out.println("books contains probe by compareTo==0: " + ArraysUtil.contains(books, probe));

    System.out.println("\n=== Tuples demo ===");
    GenericTwoTuple<String, Integer> pair = new GenericTwoTuple<>("x", 123);
    GenericThreeTuple<Integer, String, Double> triple = new GenericThreeTuple<>(7, "seven", 7.5);
    System.out.println("TwoTuple: " + pair);
    System.out.println("ThreeTuple: " + triple);
    System.out.println("ThreeTuple first: " + triple.getFirst() + ", second: " + triple.getSecond());

    System.out.println("\n=== ArraysUtil.filter demo (no matches) ===");
    Integer[] small = {1, 2, 3};
    Integer[] none = ArraysUtil.filter(small, n -> n != null && n > 100);
    System.out.println("No-match filtered length: " + none.length);
}


}
