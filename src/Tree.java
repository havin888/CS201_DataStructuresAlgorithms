public class Tree { /*
 Use this class when your method needs:
start from root and traverse the entire tree
or affects the whole tree
or you need to managing multiple nodes
*/
    /* ANOTHER NOTE FOR STUDYING: try to minimalize the questions' answer by writing it as recursive*/

        protected TreeNode root;

        public Tree(){
            root = null;
        }

        public TreeNode getRoot(){
            return root;
        }

        public void setRoot(TreeNode root){
            this.root = root;
        }

        protected void insertChild(TreeNode parent, TreeNode child){
            if (parent == null) {
                root = child;
            } else {
                if (child.data < parent.data) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

        public void iterativeInsert(TreeNode node){
            TreeNode parent = null;
            TreeNode tmp = root;
            while (tmp != null) {
                parent = tmp;
                if (node.getData() < tmp.getData()){
                    tmp = tmp.getLeft();
                } else {
                    tmp = tmp.getRight();
                }
            }
            insertChild(parent, node);
        }

        public void prettyPrint(){
            if (root != null){
                root.prettyPrint(0);
            }
        }

        public int sumOfPath(String path){ //Q16
            TreeNode tmp = root;
            int count = root.data ;
            for(int i=0;i<path.length();i++){
                if(path.charAt(i) == '0'){
                    tmp = tmp.left;
                    count += tmp.data;
                }else if(path.charAt(i) == '1'){
                    tmp = tmp.right;
                    count +=tmp.data;
                }else{
                    System.out.println("Incorrect character!");
                    break;
                }
            }
            return count; //i wrote a longer version of it lol
        }
}

