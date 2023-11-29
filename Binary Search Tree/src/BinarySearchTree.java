public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }

        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }

        return root;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }

    private boolean containsRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }

        if (element.equals(root.value)) {
            return true;
        }

        if (element.compareTo(root.value) < 0) {
            return containsRec(root.leftChild, element);
        } else {
            return containsRec(root.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> result = searchRec(root, element);
        if (result != null) {
            BinarySearchTree<E> tree = new BinarySearchTree<>();
            tree.root = result;
            return tree;
        }
        return null;
    }

    private Node<E> searchRec(Node<E> root, E element) {
        if (root == null || element.equals(root.value)) {
            return root;
        }

        if (element.compareTo(root.value) < 0) {
            return searchRec(root.leftChild, element);
        } else {
            return searchRec(root.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        }
        return null;
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        }
        return null;
    }

    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }

    public void mirror() {
        root = mirrorRec(root);
    }

    private Node<E> mirrorRec(Node<E> root) {
        if (root == null) {
            return null;
        }

        // Обмен левым и правым поддеревьями
        Node<E> temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

        // Рекурсивно зеркалим левое и правое поддеревья
        mirrorRec(root.leftChild);
        mirrorRec(root.rightChild);

        return root;
    }
}