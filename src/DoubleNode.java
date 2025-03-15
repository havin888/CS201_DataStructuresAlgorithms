public class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode previous;
    public DoubleNode(int data){
        this.data = data;
        next = null;
        previous = null;
    }
    public void setNext( DoubleNode next){
        this.next = next;
    }

    public DoubleNode getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public String toString(){
        return "" + data;
    }
}
