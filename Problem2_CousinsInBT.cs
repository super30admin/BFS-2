//Time Complexity : O(n)
//Space Complexity : O(n)
//Approach: Using DFS find the node that matches the value of x and y. 
//If the nodes are found store their level and parent nodes. Once recursion ends, compare the levels and parent nodes of x and y.
//If the levels of x and y are same and parent nodes are different then x and y are cousins, return true. Otherwise, return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int xLevel = -1;
    int yLevel = -1;
    TreeNode xParent;
    TreeNode yParent;
    public bool IsCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        CheckCousins(root, x, y, 0, null);
        return xLevel == yLevel && xParent != yParent;
    }

    private void CheckCousins(TreeNode root, int x, int y, int level, TreeNode parent) {
        if(root == null) return;
        Console.WriteLine(root.val);
        if(root.val == x) { //x is found
            xLevel = level;
            xParent = parent;
            return;
        }
        if(root.val == y) { //y is found
            yLevel = level;
            yParent = parent;
            return;
        }
        //Traverse Left
        CheckCousins(root.left, x, y, level + 1, root);
        //Traverse Right
        CheckCousins(root.right, x, y, level + 1, root);
    }
}