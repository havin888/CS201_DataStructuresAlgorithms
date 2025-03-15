
public class DisjointSet {
    private Set[] sets;
    private int count;

   /* public DisjointSet(int count) {
        sets = new Set[count];
        for (int i = 0; i < count; i++) {
            sets[i] = new Set(i, i);
        }
        this.count = count;
    }

    public DisjointSet(int[] elements, int count) {
        sets = new Set[count];
        for (int i = 0; i < count; i++) {
            sets[i] = new Set(elements[i], i);
        }
        this.count = count;
    } */

    public int findSetRecursive(int index) {
        int parent = sets[index].getParent();
        if (parent != index) {
            return findSetRecursive(parent);
        }
        return parent;
    }

    public int findSetIterative(int index) {
        int parent = sets[index].getParent();
        while (parent != index) {
            index = parent;
            parent = sets[index].getParent();
        }
        return parent;
    }

    public int numberOfSets() {
        int[] isRoot = new int[sets.length];
        int count = 0;

        for (int i = 0; i < isRoot.length; i++) {
            int root = findSetIterative(i);
            if (isRoot[root] == 0) {
                count++;
                isRoot[root] = 1;
            }
        }
        return count;
    }

    public int depth(int index) {
        int depth = 0;
        while (index != sets[index].getParent()) {
            index = sets[index].getParent();
            depth++;
        }
        return depth;
    }

    public int numberOfChildren(int index) {
        int count = 0;
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].getParent() == index && i != index) {
                count++;
            }
        }
        return count;
    }

    public int sumOfAncestors(int index) {
        int sum = 0;
        while (index != sets[index].getParent()) {
            index = sets[index].getParent();
            sum += index;
        }
        return sum;
    }

    public LinkedList getChildren(int index) {
        LinkedList childrenList = new LinkedList();

        for (int i = 0; i < sets.length; i++) {
            if (index == sets[i].getParent() && i != index) {
                Node children = new Node(i);
                childrenList.insertLast(children);
            }
        }
        return childrenList;
    }

    public LinkedList getSets() {
        LinkedList setList = new LinkedList();
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].getParent() == i) {
                Node index = new Node(i);
                setList.insertLast(index);
            }
        }
        return setList;
    }

    public int numberOfSingletons() {
        int value = 0;
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].getParent() == i) {
                boolean isSingleton = true;
                for (int j = 0; j < sets.length; j++) {
                    if (i != j && sets[j].getParent() == i) {
                        isSingleton = false;
                        break;
                    }
                }
                if (isSingleton) {
                    value++;
                }
            }
        }
        return value;
    }
    public int numberOfPairs(){
        int pairCount = 0;
        for (int i = 0; i<sets.length;i++){
            if (sets[i].getParent()==i){
                int childCount = 0;
                for (int j = 0; j<sets.length;j++){
                    if(j != i && sets[j].getParent() == i){
                        childCount++;
                    }
                }
                if(childCount==1){
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    public void unmerge(int index){
        for(int i=0; i< sets.length;i++){
            if(sets[i].getParent()==index && i!=index){
                sets[i].setParent(i);
            }
        }
    }

    LinkedList grandChildren(int index){
        LinkedList grandChildrenList = new LinkedList();
        for(int i = 0; i<sets.length;i++){
            if(sets[i].getParent()==index && i!=index){
                for (int j = 0; j<sets.length;j++){
                    if(sets[j].getParent() == i && j !=i){
                        Node newNode = new Node(j);
                        grandChildrenList.insertLast(newNode);
                    }
                }
            }
        }
        return grandChildrenList;
    }

    public void union(int index1, int index2, int index3){
        int i1 = findSetRecursive(index1);
        int i2 = findSetRecursive(index2);
        int i3 = findSetRecursive(index3);

        if (sets[i2].getDepth() < sets[i3].getDepth()) {
            sets[i3].setParent(i2);
        } else if (sets[i2].getDepth() > sets[i3].getDepth()) {
            sets[i2].setParent(i3);
        } else {
            sets[i3].setParent(i2);
            sets[i2].incrementDepth();
        }
        int newParent = findSetRecursive(i2);
        if (sets[i1].getDepth() < sets[newParent].getDepth()) {
            sets[i1].setParent(newParent);
        } else if (sets[i1].getDepth() > sets[newParent].getDepth()) {
            sets[newParent].setParent(i1);
        } else {
            sets[newParent].setParent(i1);
            sets[i1].incrementDepth();
        }
    }
    public int combine(int N, int[] left, int[] right){
        for (int i = 0; i < left.length; i++) {
            int rootLeft = findSetRecursive(left[i]);
            int rootRight = findSetRecursive(right[i]);
            if (rootLeft != rootRight) {
                if (sets[rootLeft].getDepth() < sets[rootRight].getDepth()) {
                    sets[rootLeft].setParent(rootRight);
                } else if (sets[rootLeft].getDepth() > sets[rootRight].getDepth()) {
                    sets[rootRight].setParent(rootLeft);
                } else {
                    sets[rootRight].setParent(rootLeft);
                    sets[rootLeft].incrementDepth();
                }
            }
        }
        int[] isRoot = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int root = findSetRecursive(i);
            if (isRoot[root] == 0) {
                count++;
                isRoot[root] = 1;
            }
        }
        return count;
    }
   public boolean isValid() { //Floyd's Cycle Finding Algorithm
       for (int i = 0; i < sets.length; i++) {
            int slow = i, fast = i;
            while(true){
                slow = sets[slow].getParent();
                fast = sets[fast].getParent();

                if(fast != sets[fast].getParent()){
                    fast = sets[fast].getParent();
                }
                if(slow==fast){
                    return false;
                }
                if (slow==i || fast==i){
                    break;
                }
            }
       }
       return true;
   }
   public int[] ascendants(int index){
        int[] ancestorsList = new int[sets[index].getDepth()];
        int count = 0;
        ancestorsList[count++] = index;
        while(index != sets[index].getParent()){
            index = sets[index].getParent();
            ancestorsList[count++] = index;
        }
        return ancestorsList;
   }
    public int[] numberOfDescendants(int index){
        if(sets[index].getDepth()==0){
            return new int[0];
        }
        int[] childrenList = new int[sets[index].getDepth()];
        int count = 0;
        for(int i=0; i<sets[index].getDepth();i++){
            index = sets[i].getParent();
            childrenList[count++] = index;
        }
        return childrenList;
    }
}
