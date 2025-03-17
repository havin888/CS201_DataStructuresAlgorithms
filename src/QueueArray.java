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
    public void moveToRear(){ // 1. soru
        if(!isFull()){
            int frontElement = array[first].data;
            last = (last+1) % N;
            first = (first+1) % N;
            array[last].data = frontElement;
        }
    }
    public void enlarge(){ // 2. soru
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
    public int largest(){ //4. soru
        int largest = 0;
        int size = (last >= first) ? (last - first +1) : (N - first + last +1);
        for (int i=first;i<size;i++){
            if(array[i].data>largest){
                largest = array[i].data;
            }
        }
        return largest;
    }
    public void shrink(int M){ //7. soru
        QueueArray tmp = new QueueArray(M);
        int size = (last > first) ? (last-first+1) : (N-first+last+1);
        for(int i=first; i<size;i++){
            tmp.array[i] = array[(first+1)%N];
        }
        tmp.N = M;
        tmp.first = 0;
        tmp.last = size-1;
        array = tmp.array;
    }

}
