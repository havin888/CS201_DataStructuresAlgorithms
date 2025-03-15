
public class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
    TreeNode recursiveSearch(int value){
        if (data == value)
            return this;
        else
        if (data > value)
            if (left != null)
                return left.recursiveSearch(value);
            else
                return null;
        else
        if (right != null)
            return right.recursiveSearch(value);
        else
            return null;
    }
    TreeNode iterativeMinSearch(){
        TreeNode result = this;
        while (result.left != null)
            result = result. left ;
        return result;
    }
    TreeNode recursiveMinSearch(){
        if (left == null)
            return this;
        else
            return left.recursiveMinSearch();
    }
    TreeNode iterativeMaxSearch(){
        TreeNode result = this;
        while (result.right != null)
            result = result. right ;
        return result;
    }
    TreeNode recursiveMaxSearch(){
        if (right == null)
            return this;
        else
            return right.recursiveMaxSearch();
    }
    void preorder(){
        System.out.print(data);
        if (left != null)
            left .preorder();
        if (right != null)
            right .preorder();
    }
    void inorder(){
        if (left != null)
            left .inorder ();
        System.out.print(data);
        if (right != null)
            right .inorder ();
    }
    void postorder(){
        if (left != null)
            left .postorder();
        if (right != null)
            right .postorder();
        System.out.print(data);
    }
}

class Tree{
    TreeNode root;
    public Tree(){
        root = null;
    }
    TreeNode iterativeSearch(int value){
        TreeNode d;
        d = root;
        while (d != null){
            if (d.data == value)
                return d;
            else
            if (d.data > value)
                d = d.left ;
            else
                d = d.right;
        }
        return null;
    }
    void insert(TreeNode node){
        TreeNode y = null;
        TreeNode x = root;
        while (x != null){
            y = x;
            if (node.data < x.data)
                x = x.left ;
            else
                x = x.right;
        }
        if (y == null)
            root = node;
        else
        if (node.data < y.data)
            y. left = node;
        else
            y. right = node;
    }
    TreeNode getParent(TreeNode node) {
        if (node == null || root == null || node == root) {
            return null;
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left == node || current.right == node) {
                parent = current;
                break;
            }
            if (node.data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return parent;
    }

//    void delete(int value) {
//        TreeNode y, x = root, parent;
//        while (x.data != value) {
//            parent = x;
//            if (x.data > value) {
//                x = x.left;
//            } else {
//                x = x.right;
//            }
//            parent = getParent(x);
//            while (true) {
//                if (x.left != null) {
//                    y = x.left.recursiveMaxSearch();
//                    parent = getParent(y);
//                } else {
//                    if (x.right != null) {
//                        y = x.right.recursiveMinSearch();
//                        parent = getParent(y);
//                    } else {
//                        if (parent == null)
//                            root = null;
//                        else if (parent.left == x)
//                            parent.left = null;
//                        else
//                            parent.right = null;
//                        break;
//                    }
//                }
//                x.data = y.data;
//                x = y;
//
//            }
//        }
//    }
    public TreeNode delete(int data){
        TreeNode tmp = root;
        if (tmp == null){
            return root;
        } else if (tmp.data < data) {
            return delete(data).right;
        }else if(tmp.data > data){
            return delete(data).left;
        }
        else{
            // condition 1: no child
            if(tmp.left == null && tmp.right == null){
                tmp = null;
            } else if (tmp.left !=null) { //condition 2: 1 child
                tmp.left = tmp;
                tmp = null;
            } else if (tmp.right != null) {
                tmp.right = tmp;
                tmp = null;
            } else { // condition 3: 2 child, but i cannot use minSearch so im stuck in here
                //
            }
        }
        return tmp;
    }
}