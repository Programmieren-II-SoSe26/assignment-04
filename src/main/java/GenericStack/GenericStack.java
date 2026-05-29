package GenericStack;

public class GenericStack<T> {

    private T[] data;

    // ...

    public GenericStack(int capacity) {
        data = (T[]) new Object[capacity];
        // ...
    }

    // ...
}