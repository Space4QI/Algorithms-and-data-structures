import java.util.LinkedList;

public class PriorityQueue <E extends Comparable<E>> implements AbstractQueue<E> {

    private Heap queue;

    private LinkedList<E> notOptimizedQueue;

    public PriorityQueue() {
        queue = new Heap(new LinkedList());
        notOptimizedQueue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void add(E element) {
        queue.addToHeap(element);
    }

    @Override
    public E peek() {
        return queue.peekFromHeap();
    }

    @Override
    public E poll() {
        return queue.pollFromHeap();
    }

    @Override
    public E pollByIndex(int i) {
        if (i < 0 || i >= queue.size()) {
            throw new IndexOutOfBoundsException("Данный индекс недопустим");
        }
        return queue.pollFromHeapByIndex(i);
    }


    // Алгоритм для неоптимизированной очереди с приоритетом
    @Override
    public E notOptimizedPollByIndex(int i) {
        if (i < 0 || i >= notOptimizedQueue.size()) {
            throw new IndexOutOfBoundsException("Данный индекс недопустим");
        }
        return notOptimizedQueue.remove(i);
    }

    @Override
    public void notOptimizedAdd(E element) {
        int index = 0;
        while (index < notOptimizedQueue.size() && element.compareTo(notOptimizedQueue.get(index)) < 0) {
            index++;
        }
        notOptimizedQueue.add(index, element);
    }

    public class Heap {
        private LinkedList<E> list;

        public Heap(LinkedList<E> list) {
            this.list = list;
        }

        public int size() {
            return list.size();
        }

        private void swap(int index1, int index2) {
            E temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }

        private void heapifyUp(int i, E element) {
            while (i != 0 && element.compareTo(list.get((i - 1) / 2)) > 0) { // пока добавляемый элемент не добрался до корня и добавляемый элемент больше родителя
                swap(i, (i - 1) / 2); // меняем местами родительский и дочерний элементы
                i = (i - 1) / 2; // обновляем индекс для добавленного элемента
                element = list.get(i); // обновляем сам элемент
            }
        }

        private void heapifyDown(int i) {
            while (2 * i + 1 < list.size()) { // пока не стал листом (существует хотя бы левый потомок)
                int maxChild = 2 * i + 1; // индекс максимального потомка (присваиваем левый)
                //Если существует правый потомок и он больше левого
                if (maxChild + 1 < list.size() && list.get(maxChild).compareTo(list.get(maxChild + 1)) < 0) {
                    maxChild++;
                }

                // Если родительский элемент больше максимального потомка (свойство кучи не нарушено)
                if (list.get(i).compareTo(list.get(maxChild)) > 0) {
                    break;
                }

                swap(i, maxChild); // меняем местами родительский элемент с максимальным потомком
                i = maxChild; // обновляем индекс
            }
        }

        public void addToHeap(E element) {
            if (list.size() == 0) {
                list.add(element);
            } else {
                list.add(element);
                heapifyUp(list.size() - 1, element);
            }
        }

        public E peekFromHeap() {
            if (list.size() == 0) {
                return null;
            }
            return list.getFirst();
        }

        public E pollFromHeap() {
            if (list.size() == 0) {
                return null;
            }
            E element = list.getFirst();
            list.set(0, list.getLast());
            list.removeLast();
            heapifyDown(0);
            return element;
        }

        public E pollFromHeapByIndex(int i) {
            if (list.size() == 0) {
                return null;
            }
            E element = list.get(i);
            list.set(i, list.getLast());
            list.removeLast();
            heapifyDown(i);
            return element;
        }
    }
}