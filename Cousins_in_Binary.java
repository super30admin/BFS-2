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
 Time complexity : O(N)
 Space Complexity : O(N)
 Idea : save the values once u find the node doing a traversal of the tree.
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Pair_Obj pair_1 = new Pair_Obj(0,null);;
        Pair_Obj pair_2 = new Pair_Obj(0,null);;
        depth(root,null,pair_1,pair_2,x,y,0);
        if(pair_1.depth == pair_2.depth ){
            return (pair_1.parent.val != pair_2.parent.val);
        }
        return false;
    }
    
    public void depth(TreeNode root, TreeNode parent,Pair_Obj pair_1,Pair_Obj pair_2,int x,int y,int depth)     {
        if(root == null){
            return;
        }
        if(root.val == x){
            pair_1.depth = depth;
            pair_1.parent = parent;
        }
         if(root.val == y){
            pair_2.depth = depth;
            pair_2.parent = parent;
        }
        depth(root.left,root,pair_1,pair_2,x,y,depth+1);
        depth(root.right,root,pair_1,pair_2,x,y,depth+1);
    }
    
    class Pair_Obj {
        private int depth;
        private TreeNode parent;
        
        public Pair_Obj(int depth, TreeNode parent){
            this.depth = depth;
            this.parent = parent;
        }
        
        public String toString(){
            return this.depth + " " + this.parent;
        }
        
    }
}