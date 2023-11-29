import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addToFront(Minions data) {
        Node newNode = new Node(data, head, null);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addToEnd(Minions data) {
        Node newNode = new Node(data, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public void updateAtIndex(Minions newData, int index) {
        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current != null) {
            current.data = newData;
        }
    }

    public void insertAtIndex(Minions data, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Ошибка: индекс не может быть отрицательным");
        }
        if (index == 0) {
            addToFront(data);
        } else {
            Node current = head;
            int currentIndex = 0;

            while (current != null && currentIndex < index) {
                current = current.next;
                currentIndex++;
            }
            if (current == null) {
                addToEnd(data);
            } else {
                Node newNode = new Node(data, current, current.prev);
                current.prev.next = newNode;
                current.prev = newNode;
            }
            size++;
        }
    }

    public void removeFromFront() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    public void removeFromEnd() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            size--;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Ошибка: индекс не может быть отрицательным");
        }

        if (index == 0) {
            removeFromFront();
        } else {
            Node current = head;
            int currentIndex = 0;

            while (current != null && currentIndex < index) {
                current = current.next;
                currentIndex++;
            }

            if (current != null) {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
            }
        }
    }

    public void sort(Comparator<Minions> comparator) {
        Minions[] minionsArray = new Minions[size];
        int index = 0;
        Node current = head;
        while (current != null) {
            minionsArray[index] = current.data;
            current = current.next;
            index++;
        }

        java.util.Arrays.sort(minionsArray, comparator);

        Node currentNode = head;
        for (Minions minion : minionsArray) {
            currentNode.data = minion;
            currentNode = currentNode.next;
        }
    }

    public void viewing() {
        Iterator<Minions> iterator = new DoublyLinkedListIterator();
        while (iterator.hasNext()) {
            Minions minion = iterator.next();
            System.out.println(minion);
        }
    }

    private class DoublyLinkedListIterator implements Iterator<Minions> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Minions next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Minions data = current.data;
            current = current.next;
            return data;
        }
    }
}
