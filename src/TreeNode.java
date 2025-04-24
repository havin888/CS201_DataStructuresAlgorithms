public class TreeNode { /*
Use this class when method needs to operate on a single node
or method is a recursive helper function to meant on called from individual nodes
or specific to interacting with single node attributes
*/
/* ANOTHER NOTE FOR STUDYING: try to minimalize the questions' answer by writing it as recursive*/
        protected TreeNode left;
        protected TreeNode right;
        protected int data;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public TreeNode getLeft(){
            return left;
        }

        public TreeNode getRight(){
            return right;
        }

        public int getData(){
            return data;
        }

        public void setLeft(TreeNode left){
            this.left = left;
        }

        public void setRight(TreeNode right){
            this.right = right;
        }

        public void prettyPrint(int level){
            for (int i = 0; i < level; i++){
                System.out.print("\t");
            }
            System.out.println(data);
            if (left != null){
                left.prettyPrint(level + 1);
            }
            if (right != null){
                right.prettyPrint(level + 1);
            }
        }
        public void changeChildOfSingleton() { //Q3
            if (this.left != null && this.right == null) {
                this.right = this.left;
                this.left = null;
            } else if (this.right != null && this.left == null) {
                this.left = this.right;
                this.right = null;
            }

            if (this.left != null) {
                this.left.changeChildOfSingleton();
            }
            if (this.right != null) {
                this.right.changeChildOfSingleton();
            }
        }
        public boolean containsTwoSameNumbers() { // Q4
            if (this.left != null) {
                if (this.data == this.left.data || this.left.containsTwoSameNumbers()) {
                    return true;
                }
            }
            if (this.right != null) {
                if (this.data == this.right.data || this.right.containsTwoSameNumbers()) {
                    return true;
                }
            }
            return false;
        }
        public int averages(){ //Q15
            int count = 0;
            if(left != null && right != null){
                if(2*this.data == left.data+right.data){
                    count = 1;
                }
                if(left !=null){
                    count += left.averages();
                }
                if(right !=null){
                    count += right.averages();
                }
            }
            return count;
        }
        public void accumulateLeafNodes(QueueArray queue) { //Q17
            if (left != null && right != null) {
                queue.enqueue(new Element(data));
            }
            if (left != null) {
                left.accumulateLeafNodes(queue);
            }
            if (right != null) {
                right.accumulateLeafNodes(queue);
            }
        }
        public int sumOfNodesBetween(int p, int q){ //Q20
            int sum = 0;
            if(this.data > p && this.left !=null){
                sum += this.left.sumOfNodesBetween(p,q);
            }
            if(this.data > p && this.data<q){
                sum+=this.data;
            }
            if(this.data<q && this.right != null){
                sum+= this.right.sumOfNodesBetween(p,q);
            }
            return sum;
        }
        int[] collectNodes(){ //Q21,
            /* small bug in adding length at recursive functions
            in professor's answer, so I added "+" sign
             to correctly arrange result[] size*/
            int[] leftResult = null;
            int[] rightResult = null;
            int length = 0;
            if (left != null){
                leftResult = left.collectNodes();
                length += leftResult.length;
            }
            if (right != null){
                rightResult = right.collectNodes();
                length += rightResult.length;
            }
            int[] result = new int[length + 1];
            int k = 0;
            if (leftResult != null){
                for (int i = 0; i < leftResult.length; i++){
                    result[k] = leftResult[i];
                    k++;
                }
            }
            result[k] = data;
            k++;
            if (rightResult != null){
                for (int i = 0; i < rightResult.length; i++){
                    result[k] = rightResult[i];
                    k++;
                }
            }
            return result;
        }
        public boolean isMirror(TreeNode left, TreeNode right) { //Q25
            if(left== null && right== null){
                return true;
            }
            if(left==null || right==null){
                return false;
            }
            if (left.data!=right.data){
                return false;
            }else{
                return isMirror(left.left,right.right) && isMirror(left.right,right.left);
            }
        }
}
