// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity :O(n), where n is the height of the tree (space for recursive stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain English
//1. Perform DFS traversal on the tree to find given 2 nodes (x and y) in the tree.
//2. After finding the 2 nodes (x and y) record their parents and level (depth) in the tree
//3. In the end just return if x and y have different parents and are at the same level (depth)

// Your code here along with comments explaining your approach

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
 */
class Solution {
    //taking x and y as global variables
    int cousin1;
    int cousin2;
    //to record the levels of x and y, once found in the tree
    int cousin1_depth;
    int cousin2_depth;
    //to record the parents of x and y, once found in the tree
    TreeNode cousin1_parent;
    TreeNode cousin2_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        cousin1 = x;
        cousin2 = y;
        
        dfs(root, null, 0);
        //return if x and y are at the same level in the tree and have different parents
        return cousin1_parent != cousin2_parent && cousin1_depth == cousin2_depth;
    }
    
    private void dfs( TreeNode root, TreeNode parent, int depth){
        //base
        if(root == null) return;
        //logic
        //found cousin1 (x)
        if(root.val == cousin1){
            cousin1_depth = depth;
            cousin1_parent = parent;
        }
        //found cousin2 (y)
        if(root.val == cousin2){
            cousin2_depth = depth;
            cousin2_parent = parent;
        }
        
        //call dfs of left child
        dfs(root.left, root, depth+1);
        //stack.pop()
        
        //call dfs on right child
        dfs(root.right, root, depth+1);
    }
}