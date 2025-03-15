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
    
}