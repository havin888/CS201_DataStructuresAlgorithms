public class StackLinkedList { // Linked List Implementation for Stack
    Node top;
    public StackLinkedList(){
        top = null;
    }
    boolean isEmpty(){
        if (top == null)
            return true;
        else
            return false;
    }
    void push(Node newNode){
        newNode.next = top;
        top = newNode;
    }
    Node pop(){
        Node e = top;
        if(!isEmpty())
            top = top.next;
        return e;
    }
    public Node peek(){
        return top;
    }

    public int multiply(){
        int first = top.data;
        int second = top.next.data;

        return first * second;
    }
    public StackLinkedList copy() {
        StackLinkedList newStack = new StackLinkedList();
        Node current = top;
        Node prevNode = null;

        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = prevNode;
            prevNode = newNode;
            current = current.next;
        }
        newStack.top = prevNode;
        return newStack;
    }
    public void removeOddIndexed(){
        StackLinkedList externalList = new StackLinkedList();
        int count = 0;
        while(!isEmpty()){
            Node tmp = pop();
            externalList.push(tmp);
            count++;
        }
        for(int i=1;i<=count;i++){
            if(i%2==0){
                Node tmp2 = externalList.pop();
                push(tmp2);
            }else{
                externalList.pop();
            }
        }
    }
    public void addToStack(StackLinkedList s, int p, int q){
        int count = 1;
        Node tmp = s.top;
        while(tmp !=null){
            if(count>=p && count<=q){
                Node newNode = new Node(tmp.data);
                newNode.next = top;
                top = newNode;
            }
            count++;
            tmp = tmp.next;
        }
    }

}
