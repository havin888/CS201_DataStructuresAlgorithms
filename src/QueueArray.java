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

}
