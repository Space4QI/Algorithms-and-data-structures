import java.util.Random;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Minion> priorityQueue = new PriorityQueue<>();

        // 1 Задание:
//        priorityQueue.add(new Minion("Боб", 3, 20));
//        priorityQueue.add(new Minion("Артем", 5, 60));
//        priorityQueue.add(new Minion("Луи", 125, 30));
//        priorityQueue.add(new Minion("Арнольд", 3, 1));
//        priorityQueue.add(new Minion("Гена", 5, 70));
//        priorityQueue.add(new Minion("Жорик", 125, 3));
//        priorityQueue.add(new Minion("Сармат", 125, 31));
//        priorityQueue.add(new Minion("Рося", 3, 24));

//        while (priorityQueue.size() > 0) {
//            System.out.println(priorityQueue.poll());
//        }


        //Оптимизированная очередь
        long start = System.currentTimeMillis();

        // 2 Задание:
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            int randomAge = random.nextInt(100) + 1;
            priorityQueue.add(new Minion("Рося", 3, randomAge));
        }

        for (int i = 0; i < 4998; i++) {
            priorityQueue.pollByIndex(2);
        }

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения программы с оптимизированной очередью: " + (end - start) + " миллисекунд");


        // Неоптимизированная очередь
        long start1 = System.currentTimeMillis();

        // 2 Задание:
        Random random1 = new Random();
        for (int i = 0; i < 5000; i++) {
            int randomAge = random1.nextInt(100) + 1;
            priorityQueue.notOptimizedAdd(new Minion("Рося", 3, randomAge));
        }

        for (int i = 0; i < 4998; i++) {
            priorityQueue.notOptimizedPollByIndex(2);
        }

        long end1 = System.currentTimeMillis();
        System.out.println("Время выполнения программы с неоптимизированной очередью: " + (end1 - start1) + " миллисекунд");
    }
}