package week5.day2;

class Solution1 {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left==null&&right==null)
            return;
        if(left==null || right==null || left.val!=right.val){
            flag = false;
            return; //important, otherwise this will throw null pointer
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

public class SymmetricTree_BFS {

	public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Create an instance of Solution class
        Solution1 solution = new Solution1();

        // Check if the tree is symmetric
        boolean isSymmetric = solution.isSymmetric(root);

        // Output the result
        if (isSymmetric) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
    }

}
/*
 * class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */