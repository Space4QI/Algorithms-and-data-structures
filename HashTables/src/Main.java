import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        Random random = new Random();

        // Добавляем случайные элементы
        for (int i = 0; i < 20000; i++) {
            // Генерируем случайные ключи
            String key = generateRandomString();
            // Генерируем случайные значения
            int value = random.nextInt(100);

            hashTable.add(key, value);
        }

        // Выводим информацию о таблице
        hashTable.printTableInfo();
        // Выводим число коллизий
        System.out.println("Total Collisions: " + hashTable.getCollisions());
    }

    private static String generateRandomString() {
        int leftLimit = 97; // символ 'a'
        int rightLimit = 122; // символ 'z'
        int targetStringLength = 3;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
