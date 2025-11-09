package ua.opnu;

public final class ArraysUtil {
    private ArraysUtil() {}

    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, MyPredicate<T> p) {
        Object[] tmp = new Object[input.length];
        int c = 0;
        for (T v : input) {
            if (p.test(v)) tmp[c++] = v;
        }
        return (T[]) java.util.Arrays.copyOf(tmp, c, input.getClass());
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T t : array) {
            if (t == null && element == null) return true;
            if (t != null && element != null && t.compareTo(element) == 0) return true;
        }
        return false;
    }
}
