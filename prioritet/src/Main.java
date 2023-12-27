public class Main {
    public static void main(String[] args) {
        int maxSize = 100; // Максимальный размер очереди
        PriorityQueueWithCustomPriority<String> priorityQueue = new PriorityQueueWithCustomPriority<>(maxSize);

        priorityQueue.insert("Task1", 3);
        priorityQueue.insert("Task2", 1);
        priorityQueue.insert("Task3", 2);

        System.out.println("Min Priority Task: " + priorityQueue.extractMin());

        priorityQueue.changePriority("Task2", 4);

        System.out.println("Min Priority Task after priority change: " + priorityQueue.extractMin());
    }
}