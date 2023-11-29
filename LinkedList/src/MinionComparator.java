import java.util.Comparator;

public class MinionComparator implements Comparator<Minions> {
    @Override
    public int compare(Minions minion1, Minions minion2) {
        // Сравниваем имена по количеству согласных в порядке возрастания
        int consonantsCount1 = countConsonants(minion1.getName());
        int consonantsCount2 = countConsonants(minion2.getName());
        int nameComparison = Integer.compare(consonantsCount1, consonantsCount2);

        if (nameComparison != 0) {
            return nameComparison;
        }

        // Сравниваем union по количеству гласных в порядке убывания
        int vowelsCount1 = countVowels(minion1.getUnion());
        int vowelsCount2 = countVowels(minion2.getUnion());
        int unionComparison = Integer.compare(vowelsCount2, vowelsCount1);

        if (unionComparison != 0) {
            return unionComparison;
        }

        // Сравниваем возраст по убыванию
        return Integer.compare(minion2.getAge(), minion1.getAge());
    }

    // Вспомогательная функция для подсчета количества согласных в строке
    private int countConsonants(String str) {
        String consonants = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (consonants.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Вспомогательная функция для подсчета количества гласных в строке
    private int countVowels(String str) {
        String vowels = "AEIOUaeiou";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    //имена по кол-ву согласных по возрастанию, union по кол-ву гласных по убыванию, возраст по убыванию
}
