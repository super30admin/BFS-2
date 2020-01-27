/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/

// We can do this using two hashMap, which keeps the mapping of the every nodes to its parents in one hashMap and mapping of every node to its depth in another hashmap

// BFS Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)    return false;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int count = q.size();
            boolean x_found = false, y_found = false;
            
            for(int i = 0; i < count; i++){
                
                TreeNode a = q.remove();
                
                if(a.right != null && a.left != null){
                    
                    if(a.right.val == x && a.left.val == y) return false;
                    if(a.right.val == y && a.left.val == x) return false;
                }
                
                if(a.val == x)  x_found = true;
                else if(a.val == y) y_found = true;
                
                if(a.left != null)  q.add(a.left);
                if(a.right != null) q.add(a.right);
            }
            
            if(x_found && y_found)  return true;
            
        }
        
        return false;
    }
}


// DFS Solution

// Beats 100 % of Leet Code Submissions

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode parentX, parentY;
    int depthX, depthY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        checkCousins(root, x, y, 0, null); // Root, x, y, depth, parent of Root
        
        if((parentX != parentY) && depthX == depthY) return true;
        
        return false;
    }
    
    public void checkCousins(TreeNode root, int x, int y, int depth, TreeNode parent){
        
        if(root == null)    return;
        
        if(root.val == x){
            
            parentX = parent;
            depthX = depth;
        }
        
        if(root.val == y){
            
            parentY = parent;
            depthY = depth;
        }
        
        checkCousins(root.left, x, y, depth + 1, root);
        checkCousins(root.right, x, y, depth + 1, root);
    }
}