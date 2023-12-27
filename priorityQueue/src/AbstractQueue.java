public interface AbstractQueue<E extends Comparable<E>> {
    int size();
    void add(E element);
    E peek();
    E poll();
    E pollByIndex(int i);
    E notOptimizedPollByIndex(int i);
    void notOptimizedAdd(E element);
}
