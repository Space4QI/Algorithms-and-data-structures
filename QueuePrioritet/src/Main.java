import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Тест для связанного списка
        System.out.println("Linked List Priority Queue:");
        testPriorityQueue(new PriorityQueueUsingLinkedList<>());

        // Тест для двоичного дерева
        System.out.println("\nBinary Tree Priority Queue:");
        testPriorityQueue(new BinaryTreePriorityQueue<>());
    }

    private static void testPriorityQueue(PriorityQueueUsingLinkedList<Integer> priorityQueue) {
        // Добавляем элементы

        for (int i = 1; i <= 10000; i++) {
            priorityQueue.enqueue(i);
        }

        // Изменяем приоритет
        // В случае связанного списка это неэффективно, поскольку нужно пройти по всему списку для изменения приоритета.
        // В двоичном дереве эта операция более эффективна.
        long startTime = System.nanoTime();
        priorityQueue.changePriority(5000, 7000);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nano");

        // Извлекаем элементы
        while (!priorityQueue.isEmpty()) {
            priorityQueue.dequeue();
        }
    }

    private static void testPriorityQueue(BinaryTreePriorityQueue<Integer> priorityQueue) {
        // Добавляем элементы
        for (int i = 1; i <= 10000; i++) {
            priorityQueue.enqueue(i);
        }

        // Извлекаем элементы
        while (!priorityQueue.isEmpty()) {
            priorityQueue.dequeue();
        }
        long startTime = System.nanoTime();
        priorityQueue.changePriority(5000, 7000);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nano");

        // Извлекаем элементы
        while (!priorityQueue.isEmpty()) {
            priorityQueue.dequeue();
        }

    }
}
