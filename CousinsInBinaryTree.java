/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 NLR - using Preorder traversal.
 
 TC - O(N) if the x and y are at leaf level or tree is skewed tree 
 SC - O(N) number of recursion calls in the recursive stack
 
 */

class Pair{
    TreeNode parent;
    int depth;
    
    Pair(TreeNode parent, int depth)
    {
        this.parent = parent;
        this.depth = depth;
    }
}

class Solution {
    
    boolean areCousins = false;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        isCousinsHelper(root, x,y, new Pair(root, 0));
        
        return areCousins;
    }
    
    private Pair isCousinsHelper(TreeNode root, int x, int y, Pair pair)
    {
        // base
        if (root == null)
        {
            return null;
        }
        
        if (root.val == x || root.val == y)
        {
            return pair;
        }
        
        // recurse left
        Pair leftRes = isCousinsHelper(root.left, x, y, new Pair(root, 1 + pair.depth));
        
        // recurse right
        Pair rightRes = isCousinsHelper(root.right, x, y, new Pair(root, 1 + pair.depth));
        
        if (leftRes != null && rightRes != null)
        {
            if (leftRes.parent != rightRes.parent && leftRes.depth == rightRes.depth)
            {
                areCousins = true;
            }
            else
            {
                return null;
            }
        }
        
        return leftRes == null ? rightRes : leftRes;
    }
}
