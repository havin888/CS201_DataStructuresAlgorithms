public class StackArray { // Array Implementation for Stack
    Element array[]; // we're not creating an array yet, just declaring a reference to an array that will store Element objects, right now array is null because no actual array has been created
    int top;
    int N;

    public StackArray(int N) {
        array = new Element[N];
        this.N = N;
        top = -1;
    }
    Element top() {
        return array[top];
    }

    boolean isFull() {
        if (top == N - 1)
            return true;
        else
            return false;
    }

    boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    void push(Element element) {
        if (!isFull()) {
            top++;
            array[top] = element;
        }
    }

    Element pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        }
        return null;
    }
    Element peek(){
        return array[top];
    }


    static void binary(int N) {
        int digit;
        StackArray c;
        Element e;
        c = new StackArray(1000);
        System.out.print("The number " + N + " in binary: ");
        while (N > 0) {
            digit = N % 2;
            e = new Element(digit);
            c.push(e);
            N = N / 2;
        }
        while (c.top != -1) {
            e = c.pop();
            System.out.print(e.data);
        }
    }

    public void printStack(){
        int n = top;
        while(n >= 0){
            System.out.print(array[n].data + " -> ");
            n--;
        }
        System.out.print("null ");
    }

 public static boolean isBalanced(String s){ //1. soru
        StackArray list = new StackArray(100);
        for(char ch : s.toCharArray()){
            if(ch == '('){
                list.push(new Element(ch));
            }else if(ch == ')'){
                if(list.isEmpty()){
                    return false;
                }
                list.pop();
            }
        }
        return list.isEmpty();
 }

 public static boolean upgradedIsBalanced(String s) {
     StackArray stack = new StackArray(100);
     for (char ch : s.toCharArray()) {
         Element e = new Element(ch);
         if (ch == '(' || ch == '{' || ch == '[') {
             stack.push(e);
         } else {
             if (stack.isEmpty()) {
                 return false;
             }
             Element top = stack.pop();
             if ((top.data == '(' && e.data != ')') || (top.data == '[' && e.data != ']') || (top.data == '{' && e.data != '}')) {
                 return false;
             }
         }
     }
     return stack.isEmpty();
 }
public void enlarge(){
        int newCapacity = N*2;
        Element[] newArray = new Element[newCapacity];

        for(int i=0; i<N; i++){
            newArray[i] = array[i];
        }
        array = newArray;
        N = newCapacity;
}
public static boolean palindrom(String s){
        StackArray a = new StackArray(100);
        boolean palindrom = true;
        for(char ch : s.toCharArray()){
            a.push(new Element(ch));
        }
        for(char ch : s.toCharArray()){
            if(ch !=a.pop().data){
                palindrom = false;
                break;
            }
        }
        return palindrom;
}
public Element bottom(){
        StackArray tmp = new StackArray(N);
        Element bottomElement = null;
        while(!isEmpty()){
            bottomElement = pop();
            tmp.push(bottomElement);
        }
        while(!tmp.isEmpty()){
            push(tmp.pop());
        }
        return bottomElement;
}
    public int multiply() { // With pop and push functions, getting the bottom 2 elements of the stack
        StackArray tmp = new StackArray(N);
        while (!isEmpty()){
            tmp.push(pop());
        }
        int first = tmp.pop().data;
        push(new Element(first));
        int second = tmp.pop().data;
        push(new Element(second));
        while (!tmp.isEmpty()){
            push(tmp.pop());
        }
        return first * second;
    }

    public int multiplyS() {  //corrected question
        Element secondLast = array[top - 1];
        int second = secondLast.data;
        Element last = array[top];
        int first = last.data;

        top -= 2;

        return second * first;
    }
    public void removeBottom(){
        StackArray newStack = new StackArray(N);
        while(!isEmpty()){
            Element e = pop();
            newStack.push(e);
        }
        newStack.pop();
        while (!newStack.isEmpty()){
            push(newStack.pop());
        }
    }
    public StackArray copy() {
        StackArray newStack = new StackArray(N);
        Element[] tempArray = new Element[top + 1];
        for (int i = 0; i <= top; i++) {
            tempArray[i] = array[i];
        }
        for (int i = 0; i <= top; i++) {
            newStack.array[i] = tempArray[i];
        }
        newStack.top = top;
        return newStack;
    }
    public void insertAfterLargest(int s) {
        if(top==-1){
            return;
        }
        int largest = array[0].data;
        int index = 0;
        for (int i = 1; i <= top; i++) {
            if (array[i].data > largest) {
                largest = array[i].data;
                index = i;
            }
        }
        for (int j = top; j > index; j--){
            array[j+1] = array[j];
        }
        array[index+1] = new Element(s);
        top++;
    }
    public static boolean isBalanced(int[] a){
        StackArray tmp = new StackArray(a.length);
        boolean isBalanced = true;
        for(int i=0; i<a.length;i++){
            if(a[i]< 10){
                tmp.push(new Element(a[i]));
            }else if(a[i] >= 10) {
                if (tmp.isEmpty() || a[i] - 10 != tmp.peek().data){
                    isBalanced = false;
                    break;
                }else{
                    tmp.pop();
                }
            }
        }
        if(!tmp.isEmpty()){
            isBalanced = false;
        }
        return  isBalanced;
    }


    public static void main (String[]args){
         StackArray stack1 = new StackArray(10);
         stack1.push(new Element(3));
         stack1.push(new Element(4));
         stack1.push(new Element(5));
         stack1.push(new Element(6));
         stack1.printStack();
         binary(10);
         System.out.println(upgradedIsBalanced("(())"));
         System.out.println(upgradedIsBalanced("(()"));
         System.out.println(palindrom("abcd"));
         System.out.println(palindrom("abba"));
         stack1.bottom();
    }
 }