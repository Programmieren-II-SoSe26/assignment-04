package GenericStack;

public class ArrayWrapper {

    private Object[] data;
    private int pointer;

    public ArrayWrapper(int capacity) {
        data = new Object[capacity];
        pointer = 0;
    }

    public void add(Object value) {
        data[pointer] = value;
        pointer++;
    }

    public int size() {
        return pointer;
    }

    public Object getElement(int index) {
        return data[index];
    }


}