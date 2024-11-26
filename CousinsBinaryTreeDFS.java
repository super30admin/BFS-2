// Time complexity: O(n) Each node is visited once
// Space Complexity: O(d) where d is the width of the tree
public class CousinsBinaryTreeDFS {
    private TreeNode xParent = null, yParent = null;
    private int xDepth = -1, yDepth = -1;

    public boolean isCousins(TreeNode root, int x, int y){
        dfs(root, null, 0, x, y);
        return xDepth == yDepth && xParent!= yParent;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root == null) return;

        // update xParent and depth
        if(root.val == x){
            xParent = parent;
            xDepth  = depth;
        }

        // update y's parent and depth

        if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }

        // continue searching

        dfs(root.left, parent, depth + 1 , x , y);
        dfs(root.right, parent, depth + 1 , x , y);

    }

    public static void main (String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        CousinsBinaryTreeDFS solution = new CousinsBinaryTreeDFS();
        int x =4, y = 5;

        // Getting the right side view of the binary tree
        boolean result = solution.isCousins(root, x, y);

        // Printing the result
        System.out.println("Are these cousins : " + result);
    }


}
