import java.util.LinkedList;

class PriorityQueueUsingLinkedList<E extends Comparable<E>> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E element) {
        if (list.isEmpty() || element.compareTo(list.getLast()) >= 0) {
            list.addLast(element);
        } else {
            int index = 0;
            while (index < list.size() && element.compareTo(list.get(index)) < 0) {
                index++;
            }
            list.add(index, element);
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void changePriority(E oldElement, E newElement) {
        if (!list.remove(oldElement)) {
            throw new IllegalArgumentException("Element not found in the queue");
        }
        enqueue(newElement);
    }
}
