import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.80d;

    private LinkedList<KeyValue<K, V>>[] table;
    private int size;

    private int collisions;

    public HashTable() {
        this.table = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
    }

    public HashTable(int capacity) {
        this.table = new LinkedList[capacity];
        this.size = 0;
        this.collisions = 0;
    }

    public void add(K key, V value) {
        growIfNeeded();
        int slotNumber = findSlotNumber(key);

        if (table[slotNumber] == null) {
            table[slotNumber] = new LinkedList<>();
        } else {
            // Collision occurred
            collisions++;
        }

        for (KeyValue<K, V> entry : table[slotNumber]) {
            if (entry.getKey().equals(key)) {
                // Key already exists, replace the value
                entry.setValue(value);
                return;
            }
        }

        // Key not found, add a new entry
        table[slotNumber].add(new KeyValue<>(key, value));
        size++;
    }

    public int getCollisions() {
        return collisions;
    }

    private int findSlotNumber(K key) {
        return key.hashCode() % table.length;
    }

    private void growIfNeeded() {
        if ((double) size / table.length > LOAD_FACTOR) {
            grow();
        }
    }

    private void grow() {
        int newCapacity = table.length * 2;
        LinkedList<KeyValue<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<KeyValue<K, V>> slot : table) {
            if (slot != null) {
                for (KeyValue<K, V> entry : slot) {
                    int newSlotNumber = entry.getKey().hashCode() % newCapacity;
                    if (newTable[newSlotNumber] == null) {
                        newTable[newSlotNumber] = new LinkedList<>();
                    }
                    newTable[newSlotNumber].add(entry);
                }
            }
        }

        table = newTable;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return table.length;
    }

    public boolean addOrReplace(K key, V value) {
        growIfNeeded();
        int slotNumber = findSlotNumber(key);

        if (table[slotNumber] == null) {
            table[slotNumber] = new LinkedList<>();
        }

        for (KeyValue<K, V> entry : table[slotNumber]) {
            if (entry.getKey().equals(key)) {
                // Key already exists, replace the value
                entry.setValue(value);
                return true;
            }
        }

        // Key not found, add a new entry
        table[slotNumber].add(new KeyValue<>(key, value));
        size++;
        return false;
    }

    public V get(K key) {
        int slotNumber = findSlotNumber(key);

        if (table[slotNumber] != null) {
            for (KeyValue<K, V> entry : table[slotNumber]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null; // Key not found
    }

    public KeyValue<K, V> find(K key) {
        int slotNumber = findSlotNumber(key);

        if (table[slotNumber] != null) {
            for (KeyValue<K, V> entry : table[slotNumber]) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
            }
        }

        return null; // Key not found
    }

    public boolean containsKey(K key) {
        return find(key) != null;
    }

    public boolean remove(K key) {
        int slotNumber = findSlotNumber(key);

        if (table[slotNumber] != null) {
            Iterator<KeyValue<K, V>> iterator = table[slotNumber].iterator();
            while (iterator.hasNext()) {
                KeyValue<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    return true;
                }
            }
        }

        return false; // Key not found
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : table) {
            if (slot != null) {
                for (KeyValue<K, V> entry : slot) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : table) {
            if (slot != null) {
                for (KeyValue<K, V> entry : slot) {
                    values.add(entry.getValue());
                }
            }
        }
        return values;
    }


    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        LinkedList<KeyValue<K, V>> allEntries = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : table) {
            if (slot != null) {
                allEntries.addAll(slot);
            }
        }
        return allEntries.iterator();
    }

    public void printTableInfo() {
        System.out.println("Table Info:");
        for (int i = 0; i < table.length; i++) {
            int elementsInSlot = table[i] == null ? 0 : table[i].size();
            System.out.println("Slot " + i + ": Elements = " + elementsInSlot + ", Collisions = "
                    + (elementsInSlot > 1 ? elementsInSlot - 1 : 0));

            if (table[i] != null) {
                System.out.print("Hashes: ");
                for (KeyValue<K, V> entry : table[i]) {
                    System.out.print(entry.getKey().hashCode() + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Total Size: " + size);
        System.out.println("Total Capacity: " + table.length);
        System.out.println("Load Factor: " + (double) size / table.length);
    }
}
