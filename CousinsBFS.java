/ Time Complexity : O(n) n no.of nodes
// Space Complexity : O(max width)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
BFS traversal through levels and if targets found  then checked whether their parents are same. if one target 
found then return false bcz the cousins should be in the same level



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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode>q = new LinkedList<>();
        Queue<TreeNode>p = new LinkedList<>();
        boolean x_found = false;
        boolean y_found = false; 
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        q.add(root);
        p.add(null);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                TreeNode parent = p.poll();
                if(temp.val == x){
                    x_found = true;
                    x_parent = parent;
                }
                if(temp.val == y){
                    y_found = true;
                    y_parent = parent;
                }
                if(temp.left!=null) {
                    q.add(temp.left);
                    p.add(temp);
                }
                if(temp.right!=null) {
                    q.add(temp.right);  
                    p.add(temp);
                }
           }
           if(x_found == true && y_found == true && x_parent!=y_parent)  return true;  
           if(x_found || y_found) return false;
    }
    return false;  
}
}


