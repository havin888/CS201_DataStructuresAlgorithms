public class DoublyLinkedList {
    DoubleNode head;
    DoubleNode tail;
    public DoublyLinkedList(){
        head = null;
        tail = null;
    }
    void insertFirst(DoubleNode newNode){
        if (tail == null)
            tail = newNode;
        else
            head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }
    void insertLast(DoubleNode newNode){
        if (head == null)
            head = newNode;
        else
            tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }
    void insertMiddle(DoubleNode newNode, DoubleNode previous){
        newNode.next = previous.next;
        newNode.previous = previous;
        previous.next.previous = newNode;
        previous.next = newNode;
    }
    void deleteFirst(){
        head = head.next;
        if (head == null)
            tail = null;
        else
            head.previous = null;
    }
    void deleteLast(){
        tail = tail.previous;
        if ( tail == null)
            head = null;
        else
            tail .next = null;
    }
    void deleteMiddle(DoubleNode s) {
        s.next.previous = s.previous;
        s.previous.next = s.next;
    }
    public DoublyLinkedList getEvenOnes(){
        DoublyLinkedList evenList = new DoublyLinkedList();
        DoubleNode tmp = head;
        int index = 1;
        while(tmp != null){
            if(index%2==0){
                DoubleNode evenDoubleNode = tmp;
                if(evenList.head==null){
                    evenList.head = evenDoubleNode;
                }else{
                    evenList.tail.next = evenDoubleNode;
                }
                evenDoubleNode.previous = evenList.tail;
                evenList.tail = evenDoubleNode;
            }
            tmp = tmp.next;
            index++;
        }
        return evenList;
    }
    public DoublyLinkedList sortElements(){
        DoublyLinkedList sortedList = new DoublyLinkedList();
        int largest = head.getData();
        DoubleNode tmp = head.getNext();

        while(tmp != null){
            if(tmp.getData() >largest){
                largest = tmp.data;
            }
            tmp = tmp.next;
        }
        for(int i=0; i<=largest;i++){
            int count = 0;
            tmp = head;
            while(tmp !=null){
                if(tmp.getData()==i){
                    count++;
                }
                tmp=tmp.next;
            }

            for(int j=0; j<count;j++){
                DoubleNode node = new DoubleNode(i);
                if(sortedList.head==null){
                    sortedList.head = node;
                }else{
                    sortedList.tail.next = node;
                }
                node.previous = sortedList.tail;
                sortedList.tail = node;
            }
        }
        return sortedList;
    }
    public boolean isPalindrome(){
        DoubleNode p1 = head;
        DoubleNode p2 = tail;

        while(p1 != p2 && p2 !=p1.getNext()) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.previous;
        }
        return true;
    }


    public void printLinkedList() {
        DoubleNode tmp;
        tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();

        list1.insertLast(new DoubleNode(1));
        list1.insertLast(new DoubleNode(5));
        list1.insertLast(new DoubleNode(11));
        list1.insertLast(new DoubleNode(11));
        list1.insertLast(new DoubleNode(5));
        list1.insertLast(new DoubleNode(5));
        list1.insertLast(new DoubleNode(5));
        list1.insertLast(new DoubleNode(6));

        list2.insertLast(new DoubleNode(6));
        list2.insertLast(new DoubleNode(7));

        list1.printLinkedList();
        list1.sortElements().printLinkedList();
        list2.printLinkedList();
        System.out.println(list2.isPalindrome());
    }

}
