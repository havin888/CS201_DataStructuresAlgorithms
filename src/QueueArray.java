public class QueueArray {
    Element array[];
    int first ;
    int last;
    int N;
    public QueueArray(int N){
        array = new Element[N];
        this.N = N;
        first = 0;
        last = 0;
    }
    boolean isFull(){
        if ( first == (last + 1) % N)
            return true;
        else
            return false;
    }
    boolean isEmpty(){
        if ( first == last)
            return true;
        else
            return false;
    }
    void enqueue(Element element){
        if (!isFull()){
            array[last] = element;
            last = (last + 1) % N;
        }
    }
    Element dequeue(){
        Element result;
        if (!isEmpty()){
            result = array[first];
            first = (first + 1) % N;
            return result;
        }
        return null;
    }
    public void moveToRear(){ // E1
        if(!isFull()){
            int frontElement = array[first].data;
            last = (last+1) % N;
            first = (first+1) % N;
            array[last].data = frontElement;
        }
    }
    public void enlarge(){ // E2
        if(isFull()){
            QueueArray newQueue = new QueueArray(2*N);
            int size = (last >= first) ? (last - first + 1) : (N - first + last + 1);
            for(int i = first; i<size;i++){
                newQueue.array[i] = array[(first+1) % N];
            }
            array = newQueue.array;
            first = 0;
            last = size - 1;
            N = 2*N;
        }
    }
    public int largest(){ // E4
        if(isEmpty()){
            return -1;
        }
        int largest = array[first].data;
        int i = first;
        while(i!=last){
            if (array[i].data>largest){
                largest = array[i].data;
            }
            i = (i+1) % N;
        }
        return largest;
    }
    public void shrink(int M){ // E7
        QueueArray tmp = new QueueArray(M);
        int size = (last >= first) ? (last-first+1) : (N-first+last+1);
        for(int i=first; i<size;i++){
            tmp.array[i] = array[(first+1)%N];
        }
        tmp.N = M;
        tmp.first = 0;
        tmp.last = size-1;
        array = tmp.array;
    }
    public void insertAfterKth(int K,int value){ // P1
        for(int i=last;i>K;i--){
            array[i+1] = array[i];
        }
        array[K+1] = new Element(value);
        last++;
    }
    public void deleteKth(int K){ // P2
        array[K+1] = null;
        for(int i=K+1; i<last;i++){
            array[i+1] = array[i];
        }
        last--;
    }
    public int minimum(){ //P3
        int min = array[first].data;
        int i = first;
        while (i != last){
            if (array[i].data<min){
                min = array[i].data;
            }
            i = (i+1) % N;
        }
        return min;
    }
    public void insertAfterLargest(int data){ // P5
        int largest = array[first].data;
        int i= first;
        int j = first;
        while(i!=last){
            if(array[i].data>largest){
                largest = array[i].data;
                j = i;
            }
            i = (i+1) % N;
        }
        j = (j+1) % N;
        int k = last;
       while(j != k){
           int prev = (k-1+N) % N;
           array[k] = array[prev];
           k = prev;
       }
        array[j] = new Element(data);
        last = (last+1) % N;
    }
}
