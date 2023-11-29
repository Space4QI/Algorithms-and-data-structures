import java.util.Comparator;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        DoublyLinkedList minionsList = new DoublyLinkedList();
        minionsList.addToEnd(new Minions("Mario",  "Italy", 1));
        minionsList.addToEnd(new Minions("Luigi",  "Italy", 2));
        minionsList.addToEnd(new Minions("Jack",  "Poland", 3));
        minionsList.addToEnd(new Minions("John",  "USA", 5));
        minionsList.addToEnd(new Minions("Pavel",  "Cuba", 4));
        minionsList.addToEnd(new Minions("Jerry",  "USSR", 5));
        minionsList.addToEnd(new Minions("Bob",  "Australia", 4));

        System.out.println("Список Minions:");
        minionsList.viewing();

//        System.out.println("Добавление в начало:");
//        minionsList.addToFront(new Minions("Bob",  "Australia", 4));
//        minionsList.viewing();
//
//        System.out.println("Добавление по индексу 2:");
//        minionsList.insertAtIndex(new Minions("Jerry",  "USSR", 5), 2);
//        minionsList.viewing();

        MinionComparator comparator = new MinionComparator();
        minionsList.sort(comparator);

        System.out.println("Отсортированный список Minions:");
        minionsList.viewing();
    }

}
