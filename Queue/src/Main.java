public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(8);

        System.out.println("Size: " + priorityQueue.size()); // Output: 3
        System.out.println("Peek: " + priorityQueue.peek()); // Output: 1

        System.out.println("Poll: " + priorityQueue.poll()); // Output: 1
        System.out.println("Size after poll: " + priorityQueue.size()); // Output: 2
        System.out.print("Elements after poll: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}