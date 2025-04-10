public class HashArray {

    private Element[] table;

    private boolean[] deleted;

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



}

