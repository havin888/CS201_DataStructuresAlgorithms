public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    void insertFirst(Node newNode) {
        if (tail == null)
            tail = newNode;
        newNode.next = head;
        head = newNode;
    }

    void insertLast(Node newNode) {
        if (head == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
    }

    void insertMiddle(Node newNode, Node previous) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    Node search(int value) {
        Node tmp;
        tmp = head;
        while (tmp != null) {
            if (tmp.data == value)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    Node nodeIth(int i) {
        Node tmp = head;
        int j = 0;
        while (tmp != null && j < i) {
            j++;
            tmp = tmp.next;
        }
        return tmp;
    }

    void deleteFirst() {
        head = head.next;
        if (head == null)
            tail = null;
    }

    void deleteLast() {
        Node tmp, previous;
        tmp = head;
        previous = null;
        while (tmp != tail) {
            previous = tmp;
            tmp = tmp.next;
        }
        if (previous == null)
            head = null;
        else
            previous.next = null;
        tail = previous;
    }

    void deleteMiddle(Node s) {
        Node tmp, previous;
        tmp = head;
        previous = null;
        while (tmp != s) {
            previous = tmp;
            tmp = tmp.next;
        }
        previous.next = s.next;
    }
    public void deleteValue(int value){
        Node tmp = head;
        Node previous = null;
        while (tmp != null) {
            if (tmp.getData() == value){
                if (previous != null){
                    previous.setNext(tmp.next);
                    if (tmp.next == null){
                        tail = previous;
                    }
                } else {
                    head = tmp.next;
                    if (head == null){
                        tail = null;
                    }
                }
                break;
            }
            previous = tmp;
            tmp = tmp.getNext();
        }
    }

    int nodeCount() {
        int count = 0;
        Node tmp;
        tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    static LinkedList merge(LinkedList l1, LinkedList l2) {
        LinkedList newList;
        if (l1.head == null)
            return l2;
        if (l2.head == null)
            return l1;
        newList = new LinkedList();
        newList.head = l1.head;
        newList.tail = l2.tail;
        l1.tail.next = l2.head;
        return newList;
    }

    void insertSecond(Node node) {
        if (head == null)
            insertFirst(node);
        else {
            if (head.next == null)
                insertLast(node);
            else {
                node.next = head.next;
                head.next = node;
            }
        }
    }

    static LinkedList primes(int N) {
        int i, j;
        boolean isPrime;
        LinkedList primeList;
        Node node;
        primeList = new LinkedList();
        for (i = 2; i <= N; i++) {
            isPrime = true;
            for (j = 2; j < N; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                node = new Node(i);
                primeList.insertLast(node);
            }
        }
        return primeList;
    }

    static LinkedList union(LinkedList l1, LinkedList l2) {
        int data;
        LinkedList result;
        Node tmp1, tmp2, node;
        result = new LinkedList();
        tmp1 = l1.head;
        tmp2 = l2.head;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.data < tmp2.data) {
                data = tmp1.data;
                tmp1 = tmp1.next;
            } else if (tmp1.data > tmp2.data) {
                data = tmp2.data;
                tmp2 = tmp2.next;
            } else {
                data = tmp1.data;
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
            node = new Node(data);
            result.insertLast(node);
        }
        return result;
    }

    public int smallest() {
        Node tmp, previous;
        tmp = head;
        int value = tmp.data;
        while (tmp != null) {
            previous = tmp;
            tmp = tmp.next;
            if (value > previous.data) {
                value = previous.data;
            }
        }
        return value;
    }

    public void deleteSecond() {
        Node tmp;
        tmp = head;
        tmp.next = tmp.next.next;
    }

    public void printLinkedList() {
        Node tmp;
        tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    LinkedList oddIndexedElements() {
        LinkedList list2 = new LinkedList();
        Node tmp = head;
        Node previous = null;
        int index = 0;
        while (tmp != null) {
            if (index % 2 == 1) {
                Node toRemove = tmp;
                if (previous != null) {
                    previous.next = tmp.next;
                }
                if (tmp == tail) {
                    tail = previous;
                }
                tmp = tmp.next;
                toRemove.next = null;
                list2.insertLast(toRemove);
            } else {
                previous = tmp;
                tmp = tmp.next;
            }
            index++;
        }
        return list2;
    }

    LinkedList evenIndexedElements() {
        LinkedList list2 = new LinkedList();
        Node tmp = head;
        Node previous = null;
        int index = 0;
        while (tmp != null) {
            if (index % 2 == 0) {
                Node toRemove = tmp;
                if (previous != null) {
                    previous.next = tmp.next;
                }
                if (tmp == tail) {
                    tail = previous;
                }
                tmp = tmp.next;
                toRemove.next = null;
                list2.insertLast(toRemove);
            } else {
                previous = tmp;
                tmp = tmp.next;
            }
            index++;
        }
        return list2;
    }

    public void insertBeforeLast(Node newNode) {
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
    }

    public static LinkedList fibonacci(int A, int B) { //1. Soru
        LinkedList fibonacciLinkedList = new LinkedList();
        int n1 = 0;
        int n2 = 1;
        int newNumber = 0;
        while (newNumber < B) {
            newNumber = n1 + n2;
            n1 = n2;
            n2 = newNumber;
            if (newNumber < B && newNumber > A) {
                Node newNode = new Node(newNumber);
                fibonacciLinkedList.insertLast(newNode);
            }
        }
        return fibonacciLinkedList;
    }
    public static void removeDuplicates(LinkedList A){ //2. soru
        Node tmp1 = A.head;
        Node tmp2 = A.head.next;

        while(tmp2 != null){
            if(tmp1.data==tmp2.data){
                A.deleteMiddle(tmp2);
                tmp2 = tmp2.next;
            }else{
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
        }
    }
    public static LinkedList intersection(LinkedList l1, LinkedList l2) { //4. soru
        removeDuplicates(l1);
        removeDuplicates(l2);
        LinkedList newLinkedList = new LinkedList();
        Node tmp1 = l1.head;
        Node tmp2 = l2.head;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.data == tmp2.data) {
                newLinkedList.insertLast(tmp1);
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            } else if (tmp1.data < tmp2.data) {
                tmp1 = tmp1.next;
            } else {
                tmp2 = tmp2.next;
            }
        }
        return newLinkedList;
    }
    public void deleteAll(int X){
        Node tmp = head;
        while(tmp != null){
            if(tmp.data==X){
                if(tmp==head){
                    deleteFirst();
                }else{
                    deleteMiddle(tmp);
                }
            }
            tmp = tmp.next;
        }
    }

    public boolean subList(LinkedList sub){
        boolean isSame = true;
        Node tmpOriginal = head;
        Node tmpSubList = sub.head;

        while(tmpOriginal != null){
            if(tmpOriginal != tmpSubList){
                isSame = false;
            }
            tmpOriginal = tmpOriginal.next;
            tmpSubList = tmpSubList.next;
        }
        return isSame;
    }




    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList();
        list_1.insertLast(new Node(10));
        list_1.insertLast(new Node(30));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));
        list_1.insertLast(new Node(40));


        LinkedList list_2 = new LinkedList();
        list_2.insertLast(new Node(10));
        list_2.insertLast(new Node(20));
        list_2.insertLast(new Node(40));
        list_2.insertLast(new Node(50));
        list_2.insertLast(new Node(50));

        list_1.printLinkedList();
        list_1.deleteAll(40);
        list_1.printLinkedList();
        System.out.println(list_1.subList(list_1));
    }
}