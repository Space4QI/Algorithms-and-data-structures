import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем пустое бинарное дерево
        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);

        // Вставляем значения
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(12);
        binaryTree.insert(18);

        // Выводим дерево в виде префиксного обхода с отступами
        System.out.println("Binary Tree (Pre-order):");
        System.out.println(binaryTree.asIndentedPreOrder(0));

        // Получаем список узлов в порядке инфиксного обхода
        List<AbstractBinaryTree<Integer>> inOrderList = binaryTree.inOrder();

        // Выводим значения узлов в порядке инфиксного обхода
        System.out.println("In-order values:");
        inOrderList.forEach(node -> System.out.print(node.getKey() + " "));

        // Получаем список узлов в порядке постфиксного обхода
        List<AbstractBinaryTree<Integer>> postOrderList = binaryTree.postOrder();

        // Выводим значения узлов в порядке постфиксного обхода
        System.out.println("\nPost-order values:");
        postOrderList.forEach(node -> System.out.print(node.getKey() + " "));

        // Выводим значения в порядке BFS
        System.out.println("\nBFS values:");
        binaryTree.bfs();

        // Выводим значения в порядке DFS
        System.out.println("DFS values:");
        binaryTree.dfs();
    }
}

