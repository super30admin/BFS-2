// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
It uses a helper function to traverse the tree, keeping track of each target node’s level and
parent when found. The search stops early if both nodes are located to optimize performance.
 After traversal, it compares the recorded levels and parents to determine if the nodes are cousins.
The solution efficiently tracks necessary details while traversing the tree only once.
* */

class CousinsInBInaryTree {
    int x_level,y_level;
    TreeNode x_parent,y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
        return x_level==y_level && x_parent!=y_parent;
    }
    private void helper(TreeNode root,int x,int y,int level,TreeNode parent)
    {
        if(root==null)
            return;

        if(root.val==x)
        {
            x_level=level;
            x_parent=parent;
        }

        if(root.val==y)
        {
            y_level=level;
            y_parent=parent;
        }

        if(x_parent==null || y_parent == null)
            helper(root.left,x,y,level+1,root);
        if(x_parent==null || y_parent == null)
            helper(root.right,x,y,level+1,root);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}