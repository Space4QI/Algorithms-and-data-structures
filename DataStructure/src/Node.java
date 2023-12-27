public class Node {
    public int eyes;

    int data;
    public String name;

    Node prev;
    Node next;

    public Node(int eyes, int value, String name){
        this.data = value;
        this.eyes = eyes;
        this.name = name;
        this.prev = null;
        this.next = null;
    }

    public Node(){

    }


    public Node(int data) {
    }
}
