public class DoubleLinkedList {
    static Node tail;
    static Node head;

    public DoubleLinkedList(){
        this.tail = null;
        this.head = null;

    }



    public void traverseForward()
    {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void traverseBackward()
    {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public void insertAtBeginning(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtTheEnd(int data){
        Node temp = new Node(data);
        if(tail == null){
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void insertInPosition(int data, int position){
        Node temp = new Node(data);
        if(position == 1){
            insertAtBeginning(data);
        }
        else{
            Node current = head;
            int curPosition = 1;
            while(current != null && curPosition < position){
                current = current.next;
                curPosition++;
            }
            if(current == null){
                insertAtTheEnd(data);
            }
            else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    public void deleteAtBeginning(int data){
        if(head == null){
            return;
        }
        else if(head == tail){
            head = null;
            tail = null;
            return;
        }
    }

}
