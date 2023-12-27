

public class BinaryTreePriorityQueue<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BinaryTreePriorityQueue() {
        this.root = null;
    }

    public void enqueue(E element) {
        root = insert(root, element);
    }

    private TreeNode<E> insert(TreeNode<E> node, E element) {
        if (node == null) {
            return new TreeNode<>(element);
        }

        if (element.compareTo(node.data) < 0) {
            node.left = insert(node.left, element);
        } else {
            node.right = insert(node.right, element);
        }

        return node;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        TreeNode<E> minNode = findMin(root);
        root = delete(root, minNode.data);

        return minNode.data;
    }

    private TreeNode<E> delete(TreeNode<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.data) < 0) {
            node.left = delete(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = delete(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = findMin(node.right).data;
            node.right = delete(node.right, node.data);
        }

        return node;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void changePriority(E oldElement, E newElement) {
        root = delete(root, oldElement);
        root = insert(root, newElement);
    }
}
