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

//nodes should be of same level but different parents

// BFS solution
//TC: o(n)
//SC: o(h) height of the tree

class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                boolean x_found = false;
                boolean y_found = false;
                int size = q.size();
                for(int i =0;i<size;i++){
                    TreeNode curr = q.poll();
                    // setting the flag if the elemnts are found
                    if(curr.val == x) x_found = true;
                     if(curr.val == y) y_found = true;
                    // before adding to the queue check if the right and left nodes are from same parents
                    //if from same parent return false
                    if(curr.left !=null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y ) return false;
                    if(curr.right.val == x && curr.left.val == y ) return false;
                        }
                    // add left and right node to the queue
                    if(curr.left !=null) q.add(curr.left);
                    if(curr.right !=null) q.add(curr.right);
                }
                if(x_found && y_found) return true;
            }
            
            return false;
        }
}
//Dfs solution


//TC: o(n)
//SC: o(h) height of the tree
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        helper(root,x,y,null,0);
        //return true if these conditon satisfies
        return x_parent != y_parent && x_depth == y_depth;
    }
    
    private void helper(TreeNode root, int x, int y,TreeNode parent,int depth){
        
        if(root == null) return;
        
        //if x is found set x parent and x depth;
        if(root.val ==x){
           x_parent = parent; 
            x_depth = depth;
        }
        
         //if x is found set y parent and y depth;
         if(root.val ==y){
           y_parent = parent; 
            y_depth = depth;
        }
        // optimization if x parent and y parent are found stop the recursion
        if(x_parent == null || y_parent == null) {
        helper(root.left,x,y,root,depth+1);
        helper(root.right,x,y,root,depth+1);
        }
    }
}
