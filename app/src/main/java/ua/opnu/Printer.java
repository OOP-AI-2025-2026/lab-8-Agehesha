package ua.opnu;

public class Printer {
    public <T> void printArray(T[] array) {
        if (array == null) return;
        for (T t : array) {
            System.out.println(t);
        }
    }
}
