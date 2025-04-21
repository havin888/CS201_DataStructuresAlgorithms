public class HashList {

        private LinkedList[] table;

        private int N;

        public HashList(int N) {
            table = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                table[i] = new LinkedList();
            }
            this.N = N;
        }

        public Node search(int value) {
            int address;
            address = hashFunction(value);
            return table[address].search(value);
        }

        public void insert(int value) {
            int address;
            address = hashFunction(value);
            table[address].insertLast(new Node(value));
        }

        public void insert(Node node) {
            int address;
            address = hashFunction(node.data);
            table[address].insertLast(node);
        }

        public void deleteValue(int value) {
            int address;
            if (search(value) != null) {
                address = hashFunction(value);
                table[address].deleteValue(value);
            }
        }

        private int hashFunction(int value) {
            return value % N;
        }


        public HashList simplify(){ //Q6
            int j=0;
            HashList solution = new HashList(table.length);
            for(int i=0; i<table.length;i++){
                Node tmp = table[j].head;
                while(tmp != null){
                    if(solution.search(tmp.data) == null){
                        solution.insert(tmp);
                    }
                    tmp = tmp.next;
                }
            }
            return solution;
        }
        public boolean perfectMap(){ //Q8
            for(int i=0; i<N;i++){
                LinkedList tmp = table[i];
                if(tmp.head != null && tmp.head.next != null){
                    return false;
                }
            }
            return true;
        }
    public boolean isValid() { //Q13
        for (int i = 0; i < N; i++) {
            Node current = table[i].head;
            while (current != null) {
                Node runner = current.next;
                while (runner != null) {
                    if (runner.data == current.data) {
                        return false;
                    }
                    runner = runner.next;
                }
                current = current.next;
            }
        }
        return true;
    }
}
