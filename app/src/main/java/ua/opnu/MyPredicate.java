package ua.opnu;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T value);
}
