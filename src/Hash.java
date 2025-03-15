public class Hash {
    private Integer[] table;
    private boolean[] deleted;
    private int size; // Current number of elements in the hash table

    public Hash(int capacity) {
        table = new Integer[capacity];
        deleted = new boolean[capacity];
        size = 0;
    }

    private int hash(int value) {
        return value % table.length; // Simple hash function
    }

    public void insert(int value) {
        int index = hash(value);
        while (table[index] != null && !deleted[index]) {
            index = (index + 1) % table.length; // Linear probing
        }
        table[index] = value;
        deleted[index] = false; // Reset the deleted flag
        size++;
    }

    public void delete(int value) {
        int index = hash(value);
        while (table[index] != null) {
            if (table[index] == value && !deleted[index]) {
                deleted[index] = true; // Mark as deleted
                size--;
                return;
            }
            index = (index + 1) % table.length; // Linear probing
        }
    }

    public void undelete(int value) {
        int index = hash(value);
        while (table[index] != null) {
            if (table[index] == value && deleted[index]) {
                deleted[index] = false; // Undelete the value
                size++;
                return;
            }
            index = (index + 1) % table.length; // Continue probing
        }
        insert(value);
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print((table[i] != null ? table[i] : "-") + (deleted[i] ? "(D)" : "") + " ");
        }
        System.out.println();
    }

    int numberOfClusters(){
        int count = 0;
        boolean inCluster = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (!inCluster) {
                    count++;
                    inCluster = true;
                }
            } else {
                inCluster = false;
            }
        }
        return count;
    }

    boolean perfectMap(){
        for(int i=0; i<table.length;i++){
            LinkedList list = new LinkedList();
            if(list.head != null && list.head.next != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Hash hashTable = new Hash(7);
        hashTable.insert(6);
        hashTable.insert(3);
        hashTable.insert(8);
        hashTable.printTable();
        System.out.println(hashTable.numberOfClusters());
        System.out.println(hashTable.perfectMap());
    }
}

