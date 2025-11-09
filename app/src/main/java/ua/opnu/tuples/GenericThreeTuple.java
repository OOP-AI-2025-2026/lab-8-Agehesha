package ua.opnu.tuples;

public class GenericThreeTuple<T, V, S> {
private final GenericTwoTuple<T, V> two;
public final S three;

public GenericThreeTuple(T first, V second, S three) {
    this.two = new GenericTwoTuple<>(first, second);
    this.three = three;
}

public T getFirst() { return two.first; }
public V getSecond() { return two.second; }

@Override
public String toString() {
    return "(" + getFirst() + "," + getSecond() + "," + three + ")";
}


}
