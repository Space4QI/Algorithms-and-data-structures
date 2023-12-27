public class PriorityQueueWithCustomPriority<T> {
    private Object[] elements;

    public PriorityQueueWithCustomPriority(int maxSize) {
        this.elements = new Object[maxSize];
    }

    public void insert(T element, int priority) {
        int index = getUniqueIdentifier(element);
        if (index < elements.length) {
            elements[index] = new QueueElement<>(element, priority);
            heapifyUp(index);
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    public T extractMin() {
        if (isEmpty()) {
            return null;
        }

        QueueElement<T> minElement = (QueueElement<T>) elements[0];
        int lastIndex = getUniqueIdentifier(minElement.element);
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;

        heapifyDown(0);

        return minElement.element;
    }

    public void changePriority(T element, int newPriority) {
        int index = getUniqueIdentifier(element);
        if (index < elements.length) {
            QueueElement<T> queueElement = (QueueElement<T>) elements[index];
            int oldPriority = queueElement.priority;
            queueElement.priority = newPriority;

            // Переупорядочиваем кучу в соответствии с изменением приоритета
            if (newPriority < oldPriority) {
                heapifyUp(index);
            } else {
                heapifyDown(index);
            }
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    public boolean isEmpty() {
        return elements[0] == null;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            QueueElement<T> current = (QueueElement<T>) elements[index];
            QueueElement<T> parent = (QueueElement<T>) elements[parentIndex];

            if (current.priority < parent.priority) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < elements.length && ((QueueElement<T>) elements[leftChild]).priority < ((QueueElement<T>) elements[smallest]).priority) {
                smallest = leftChild;
            }

            if (rightChild < elements.length && ((QueueElement<T>) elements[rightChild]).priority < ((QueueElement<T>) elements[smallest]).priority) {
                smallest = rightChild;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private int getUniqueIdentifier(T element) {
        // Предполагается, что element - это уникальный идентификатор
        // (например, целочисленный или строковый)
        // и может быть использован в качестве индекса массива
        // В реальном коде нужно обеспечивать уникальность идентификаторов
        // или использовать другие способы генерации индексов.
        return (element != null) ? element.hashCode() % elements.length : -1;
    }

    private static class QueueElement<T> {
        T element;
        int priority;

        QueueElement(T element, int priority) {
            this.element = element;
            this.priority = priority;
        }
    }
}