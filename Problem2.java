// ## Problem 2

// Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)


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

// Cousins should have same horizontal level but different parents
class Solution {
    //1. BFS
    // Time - O(N)
    // Space - O(N)
    private boolean bfsHelper(TreeNode root, int x, int y){
        if(root==null)  return false;

        // Pair of child, and parent queue
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            // Size of level
            int size_n=q.size();

            // Process current level
            // Check if x and y are found
            boolean x_found=false;
            boolean y_found=false;

            for(int i=0;i<size_n;i++){
                TreeNode curr=q.poll();


                // Check for x
                if(curr.val==x){
                    x_found=true;
                }

                // Check for y
                if(curr.val==y){
                    y_found=true;
                }

                // Check for same parent
                if(curr.left!=null && curr.right!=null && curr.left.val==x && curr.right.val==y){
                    return false;
                }
                if(curr.left!=null && curr.right!=null && curr.left.val==y && curr.right.val==x){
                    return false;
                }

                // Add current's children
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

            if(x_found && y_found)  return true;
            if(x_found||y_found)    return false;
        }

        return false;
    }

    //2. DFS - same horizontal level but different parents
    // Time - O(N)
    // Space - O(H)
    private TreeNode x_parent;
    private TreeNode y_parent;
    private int x_depth;
    private int y_depth;
    private void dfsHelper(TreeNode root, TreeNode parent, int depth, int x, int y){
        //base
        if(root==null)  return;
        System.out.println(root.val);

        //logic
        if(root.val==x){
            x_parent=parent;
            x_depth=depth;
        }
        if(root.val==y){
            y_parent=parent;
            y_depth=depth;
        }
    
        dfsHelper(root.left, root, depth+1,x,y);
        dfsHelper(root.right, root, depth+1,x,y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        //1. BFS
        //return bfsHelper(root,x,y);

        //2. DFS
        dfsHelper(root,null,0,x,y);
        return x_depth==y_depth && x_parent!=y_parent;
    }
}