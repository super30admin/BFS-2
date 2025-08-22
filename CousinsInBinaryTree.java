import javax.swing.tree.TreeNode;

public class CousinsInBinaryTree {
    //Use DFS to find the elements their levels and parents
    //Compare their levels and parents to return true or false
    //Time Complexity: O(n)
    //Space Complexity:O(n)
    int x_level = 0;
    int y_level = 0;
    TreeNode x_parent = null;
    TreeNode y_parent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,null,0);
        return x_level==y_level && x_parent != y_parent;
    }

    public void helper(TreeNode node, int x, int y, TreeNode parent, int level)
    {
        if(node==null)
        {
            return;
        }
        if(node.val==x && x_parent==null)
        {
            x_level = level;
            x_parent = parent;
        }
        if(node.val==y && y_parent==null)
        {
            y_level = level;
            y_parent = parent;
        }
        helper(node.left,x,y,node,level+1);
        helper(node.right,x,y,node,level+1);
    }
}
