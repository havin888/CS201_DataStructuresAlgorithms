public class CircularList {
    DoubleNode head;
    public  CircularList(){
        head = null;
    }
    void insertFirst(DoubleNode newNode){
        if (head == null){
            newNode.next = newNode;
            newNode.previous = newNode;
            }else{
            newNode.next = head;
            newNode.previous = head.previous;
            head.previous.next = newNode;
            head.previous = newNode;
        }
        head = newNode;
    }
    void deleteFirst(){
        if (head.next == head)
            head = null;
        else{
            head.previous.next = head.next;
            head.next.previous = head.previous;
            head = head.next;
        }
    }
}
