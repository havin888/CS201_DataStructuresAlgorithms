public class TreeNode { /*
Use this class when method needs to operate on a single node
or method is a recursive helper function to meant on called from individual nodes
or specific to interacting with single node attributes
*/

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

}
