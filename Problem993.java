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
//DFS
// Time Complexity : O(n)  
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    TreeNode x_parent ;
    TreeNode y_parent;
    int x_depth =0;
    int y_depth =0;
       public boolean isCousins(TreeNode root, int x, int y) {
           if(root ==null) return false;
           helper(root,x,y,0,null);
           return x_depth == y_depth && x_parent!=y_parent;
       }
   
       public void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
           //base case
           if(root==null) return ;
   
           if(root.val==x){
               x_depth = depth;
               x_parent= parent;
           
           }
           if(root.val==y){
               y_depth = depth;
               y_parent = parent;
           }
           
           if(x_parent==null || y_parent==null)
            helper(root.left,x,y,depth+1,root) ;
            if(x_parent==null || y_parent==null)
           helper(root.right,x,y,depth+1,root);
           
       }
    }
    // BFS
    // Time Complexity : O(n)  
    // Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
       class Solution {
       public boolean isCousins(TreeNode root, int x, int y) {
           
   
           Queue<TreeNode> queue = new LinkedList<>();
           queue.add(root);
           while(!queue.isEmpty())
           {
               boolean x_found = false;
               boolean y_found= false;
               int size = queue.size();
               for(int i=0;i<size;i++)
               {
                   TreeNode curr = queue.poll();
                   if(x==curr.val){
                       x_found = true;
                   }
                    if(y==curr.val){
                       y_found = true;
                   }
                   if(curr.left!=null && curr.right !=null){
                       if(curr.left.val==x && curr.right.val ==y) return false; // they have same parent current
                        if(curr.left.val==y && curr.right.val ==x) return false;
                   }
                   if(curr.left!=null) queue.add(curr.left);
                   if(curr.right!=null) queue.add(curr.right);
               }
   
               if(x_found && y_found) return true;  // both of them found at same level
               if(x_found || y_found) return false; // one of them only found at this level so return false
   
               
           }
           return false;
           
       }
   }