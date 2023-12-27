import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
        heapifyUp();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E root = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        heapifyDown();

        return root;
    }

    private void heapifyUp() { //восстановление свойства кучи при добавлении
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() { //восстановление свойства кучи при удалении
        int currentIndex = 0;
        int leftChildIndex;
        int rightChildIndex;

        while (true) {
            leftChildIndex = 2 * currentIndex + 1;
            rightChildIndex = 2 * currentIndex + 2;

            int smallestIndex = currentIndex;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != currentIndex) {
                swap(currentIndex, smallestIndex);
                currentIndex = smallestIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }


}
