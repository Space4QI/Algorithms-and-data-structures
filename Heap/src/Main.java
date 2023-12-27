public class Main {
    public static void main(String[] args) {
        // Создаем MaxHeap для целых чисел
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        // Добавляем элементы в кучу
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(8);

        // Выводим размер кучи
        System.out.println("Size of the MaxHeap: " + maxHeap.size());

        // Получаем и выводим максимальный элемент без удаления
        System.out.println("Peek: " + maxHeap.peek());

        // Добавляем еще элемент и выводим новый размер кучи
        maxHeap.add(15);
        System.out.println("Size after adding 15: " + maxHeap.size());

        // Выводим новый размер кучи после извлечения
        System.out.println("Size after extraction: " + maxHeap.size());
    }
}
