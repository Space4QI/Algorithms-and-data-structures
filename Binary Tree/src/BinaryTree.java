import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<E extends Comparable<E>> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = left;
    }

    @Override
    public void setRight(AbstractBinaryTree<E> right) {
        this.right = right;
    }

    public void insert(E value) {
        if (value.compareTo(key) < 0) {
            if (left == null) {
                left = new BinaryTree<>(value);
            } else {
                ((BinaryTree<E>) left).insert(value);
            }
        } else if (value.compareTo(key) > 0) {
            if (right == null) {
                right = new BinaryTree<>(value);
            } else {
                ((BinaryTree<E>) right).insert(value);
            }
        }
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        result.append("  ".repeat(Math.max(0, indent))).append(key).append("\n");

        if (left != null) {
            result.append(((BinaryTree<E>) left).asIndentedPreOrder(indent + 1));
        }
        if (right != null) {
            result.append(((BinaryTree<E>) right).asIndentedPreOrder(indent + 1));
        }

        return result.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(((BinaryTree<E>) left).preOrder());
        }
        if (right != null) {
            result.addAll(((BinaryTree<E>) right).preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(((BinaryTree<E>) left).inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(((BinaryTree<E>) right).inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(((BinaryTree<E>) left).postOrder());
        }
        if (right != null) {
            result.addAll(((BinaryTree<E>) right).postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            ((BinaryTree<E>) left).forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            ((BinaryTree<E>) right).forEachInOrder(consumer);
        }
    }

    // BFS (Поиск в ширину)
    public void bfs() {
        Queue<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();
            System.out.print(current.getKey() + " ");

            if (current.getLeft() != null) {
                queue.add((BinaryTree<E>) current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add((BinaryTree<E>) current.getRight());
            }
        }
        System.out.println();
    }

    // DFS (Поиск в глубину)
    public void dfs() {
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            BinaryTree<E> current = stack.pop();
            System.out.print(current.getKey() + " ");

            if (current.getRight() != null) {
                stack.push((BinaryTree<E>) current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push((BinaryTree<E>) current.getLeft());
            }
        }
        System.out.println();
    }
}
