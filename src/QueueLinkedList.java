public class QueueLinkedList{
    Node first ;
    Node last;
    public QueueLinkedList(){
        first = null;
        last = null;
    }
    boolean isEmpty(){
        if ( first == null)
            return true;
        else
            return false;
    }
    void enqueue(Node node){
        if (!isEmpty())
            last .next = node;
        else
            first = node;
        last = node;
    }
    Node dequeue(){
        Node result;
        result = first ;
        if (!isEmpty()){
            first = first .next;
            if ( first == null)
                last = null;
        }
        return result;
    }
    public void moveToFront(){ // E5
        Node tmp = first;
        enqueue(new Node(last.data));
        while(tmp.next.next != null){
            tmp = tmp.next;
        }
        last = tmp;
    }
    public void insertSecond(Element newElement) { // E6
        if (isEmpty()) {
            enqueue(new Node(newElement.getData()));
        } else {
            Node newNode = new Node(newElement.getData());
            newNode.next = first.next;
            first.next = newNode;
        }
    }
    public int minimum(){ //P3
        Node tmp = first;
        int min = tmp.data;
        while(tmp != null){
            if(tmp.data<min){
                min = tmp.data;
            }
            tmp = tmp.next;
        }
        return min;
    }
}