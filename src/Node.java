public class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public String toString(){
        return "" + data;
    }

}