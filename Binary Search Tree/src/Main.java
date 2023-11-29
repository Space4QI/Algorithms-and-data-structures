public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Вставка элементов в бинарное дерево
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        System.out.println("Tree contains 5: " + bst.contains(5)); // true
        System.out.println("Tree contains 9: " + bst.contains(9)); // false

        // Вывод исходного дерева
        System.out.println("Original Tree: " + printTree(bst.getRoot()));

        // Зеркальное отражение дерева
        bst.mirror();

        // Вывод зеркально отраженного дерева
        System.out.println("Mirrored Tree: " + printTree(bst.getRoot()));
    }

    private static String printTree(AbstractBinarySearchTree.Node<Integer> root) {
        StringBuilder result = new StringBuilder();
        printTreeRecursive(root, result);
        return result.toString();
    }

    private static void printTreeRecursive(AbstractBinarySearchTree.Node<Integer> root, StringBuilder result) {
        if (root != null) {
            result.append(root.value).append(" ");
            printTreeRecursive(root.leftChild, result);
            printTreeRecursive(root.rightChild, result);
        }
    }

}