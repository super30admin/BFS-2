// Time Complexity  O(n) each node is visited exactly once
// Space complexity O(h) the space required is due to the recurrsion stack which depends on height h  of the tree.
//In the best case (balanced tree) h = log n
//In the worst case (skewed tree),h =n
public class SymmetricTreeDFS {

    public boolean isSymmetric (TreeNode root){
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1,  TreeNode t2){

        if(t1 == null && t2 == null) return true; // both are null - true
        if(t1 == null || t2 == null) return false; // one is null
        if(t1.val != t2.val) return false; // values are different

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);

    }

    public static void main (String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTreeDFS solution = new SymmetricTreeDFS();
        System.out.println("Is the tree symmetric? " + solution.isSymmetric(root)); // Output: true
    }
}
