
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (Integer item : stack) {
            System.out.println(item);
        }
        System.out.println(stack.peek());
    }
}