// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Check for each and every node is parent is equal to the node given
// height of the nodes where match is found should also be equal
// if one of the node is found and other is not found at a purticular level then return false

// Your code here along with comments explaining your approach
public class IsCousins {
    TreeNode x_parent;
     TreeNode y_parent;
     boolean x_found;
     boolean y_found;
     int x_ht;
     int y_ht;

     public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        IsCousins cousins = new IsCousins();
        System.out.println(cousins.isCousins(root,4,3));

     }
    public boolean isCousins(TreeNode root, int x, int y) {
     
    dfs(root,x,y,0, null);  
     
     return x_found && y_found && x_parent != y_parent && x_ht == y_ht;
        
        
    }
    
    void dfs(TreeNode root, int x_val, int y_val,int depth, TreeNode parent) {
        
        if(root == null) return;
        
        if(root.val == x_val){
            x_parent = parent;
            x_found = true;
            x_ht = depth;
        }
        if(root.val == y_val){
            y_parent = parent;
            y_found = true;
            y_ht = depth;
        }
        
        dfs(root.left, x_val,y_val, depth+1,root);
        dfs(root.right, x_val,y_val, depth+1,root);
        
       
       // return false;
    }
}

  //Definition for a binary tree node.
class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }
}
