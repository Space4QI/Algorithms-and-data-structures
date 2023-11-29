import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void push(T item) {
        if (size == capacity) {
            throw new IllegalStateException("Stack is full");
        }
        array[size] = item;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        T item = (T) array[size];
        array[size] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = size - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return (T) array[currentIndex--];
            }
        };
    }
}