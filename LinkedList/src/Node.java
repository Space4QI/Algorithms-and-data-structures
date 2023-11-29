public class Node {
    protected Minions data;
    protected Node prev;
    protected Node next;

    public Node(Minions data, Node next, Node prev)
    {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

}