interface MyPriorityQueue<T> {
    void enqueue(T element, int priority);
    T dequeue();

    void offer(T element, int priority);

    T poll();

    boolean isEmpty();
}