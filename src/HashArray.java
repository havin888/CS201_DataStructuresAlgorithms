public class HashArray {

    private Element[] table;

    private boolean[] deleted; // do not forget to update this array when deleting something in the hash table

    private int N;

    public HashArray(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value){
        return value % N;
    }

    public Element search(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null){
            if (!deleted[address] && table[address].getData() == value){
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address]){
            address = (address + 1) % N;
        }
        if (table[address] != null){
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }
    public void deleteValue(int value) {
        int address;
        address = hashFunction(value);
        while (table[address] != null) {
            if (!deleted[address] && table[address].getData() == value) {
                break;
            }
            address = (address + 1) % N;
        }
        deleted[address] = true;
    }

    public boolean jollyJumper(int[] sequence) { //Q1
        int n = sequence.length;
        if(n==1){
            return true;
        }
        HashArray differList = new HashArray(n);
        for(int i=0; i<n-1;i++){
            int difference = Math.abs(sequence[i] - sequence[i+1]);
            if(difference<1 || difference >= n ||differList.search(difference) != null){
                return false;
            }
            differList.insert(difference);
        }
        return true;
    }
    public static boolean anyDuplicate(int[] array){ //Q5
        HashArray tmp = new HashArray(array.length);
        for(int i:array){
            if(tmp.search(i)==null){
                tmp.insert(i);
            }else{
                return false;
            }
        }
        return true;
    }

    public int numberOfClusters(){ //Q7
        int count = 0;
        for(int i=0; i < N; i++){
            if(table[i] == null && table[(i+1) % N] != null){
                count++;
            }
        }
        if(count == 0){
            return 1;
        }else{
            return count;
        }
    }
    public static int numberOfExtras(int[] array){ //Q9
        HashArray tmp = new HashArray(array.length);
       int extra = 0;

       for(int i: array){
           if(tmp.search(i)==null){
               tmp.insert(i);
           }else{
               extra++;
           }
       }
        return extra;
    }
    static int[] sortByHashing(int[] array) { //Q10
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        HashArray table = new HashArray(2 * array.length);
        for (int i = 0; i < array.length; i++) {
            table.insert(array[i]);
        }
        int[] result = new int[array.length];
        int index = 0;
        for (int i = 1; i <= max; i++) {
            if (table.search(i) != null) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }
    public int[] intersection(int[] list1, int[] list2){ //Q11
        int count = list1.length;
        HashArray tmp = new HashArray(list1.length + list2.length);
        for (int k : list1) {
            tmp.insert(k);
        }
        for (int value : list2) {
            if (tmp.search(value) != null) {
                count++;
            }
        }
        int[] intersection = new int[count];
        int j = 0;
        for (int k : list1) {
            intersection[j++] = k;
        }
        for (int k : list2) {
            if (tmp.search(k) != null) {
                intersection[j++] = k;
            }
        }
        return intersection;
    }

    public boolean sumOfTwo(int[] array, int k){ //Q12
        HashArray table = new HashArray(100);
        for(int i=0; i<array.length;i++){
            table.insert(array[i]);
        }
        for(int i=0; i<array.length;i++){
            if(table.search(k-array[i]) != null){
                /*taking the complement of k
                to see if there's any number matching
                with array[i] */
                return true;
            }
        }
        return false;
    }
    public static boolean sumOfFourK(int[] array, int K) { //Q14
        int n = array.length;
        HashArray pairSums = new HashArray(n);
        int totalLength = n^2;
        int[] tempPairs = new int[totalLength];
        int index = 0;

        for (int i = 0; i < n; i++) { //O(N^2) part
            for (int j = 0; j < n; j++) {
                int sum = array[i] + array[j];
                pairSums.insert(sum);
                tempPairs[index] = sum;
                index++;
            }
        }
        for (int sum1 : tempPairs) {
            int sum2 = K - sum1;
            if (pairSums.search(sum2) != null) {
                return true;
            }
        }
        return false;
    }
    public static int[] union(int[] list1, int[] list2){ //Q15
        HashArray tmp = new HashArray(100);
        int size = list1.length;
        for (int j : list1) {
            tmp.insert(j);
        }
        for (int j : list2) {
            if (tmp.search(j) == null) {
                size++;
            }
        }
        int[] unionArray = new int[size];
        int index = 0;
        for (int j : list1) {
            unionArray[index++] = j;
        }
        for (int j : list2) {
            if (tmp.search(j) == null) {
                unionArray[index++] = j;
            }
        }
        return unionArray;
    }
    public static void printArray (int[] list){
        //test function to print arrays
        for(int i=0; i<list.length;i++){
            System.out.print(list[i] + " -> ");
        }
    }
    public static void main(String[] args) {
        int[] testList1 = new int[3];
        int[] testList2 = new int[2];
        int tmp = 1;
        for(int i=0; i<testList1.length-1;i++){
            testList1[i] = tmp;
            tmp++;
        }
        testList1[2] = 4;
        for(int i=0; i<testList2.length;i++){
            testList2[i] = tmp;
            tmp++;
        }
        int[] testList3 = {1,1,1,3,3,3};
        printArray(testList1);
        printArray(testList2);
        printArray(union(testList1,testList2));
        System.out.println(numberOfExtras(testList3));
    }
}

