// Time Complexity - O(n) - for DFS
// Space Complexity - O(h) - h is the height of the tree - for DFS

// Time Complexity - O(n) - for BFS
// Space Complexity - O(n) - for BFS
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

    // DFS Implementation
    // int xDepth; int yDepth;
    // TreeNode xParent; TreeNode yParent;
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     dfs(root,x,y,0,null);
    //     return xParent!=yParent && xDepth==yDepth;
    // }

    // private void dfs(TreeNode root,int x,int y, int level, TreeNode parent){
    //     // base
    //     if(root == null) return;

    //     // logic
    //     if(root.val == x){
    //         xDepth = level;
    //         xParent = parent;
    //     }
    //     if(root.val == y){
    //         yDepth = level;
    //         yParent = parent;
    //     }

    //     dfs(root.left,x,y,level+1,root);
    //     dfs(root.right,x,y,level+1,root);
    // }

    // BFS Implementation
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode parent;
        boolean xFound = false; boolean yFound = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            // level processing
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null && temp.right!=null && (temp.left.val==x && temp.right.val==y) 
                     || (temp.left!=null && temp.right!=null && (temp.left.val==y && temp.right.val==x))){
                    return false;
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                if(temp!=null && temp.val==x){
                    xFound = true;
                }
                if(temp!=null && temp.val==y){
                    yFound = true;
                }
                if(temp!=null && temp.val==x){
                    xFound = true;
                }
                if(temp!=null && temp.val==y){
                    yFound = true;
                }
            }
            if(xFound==true && yFound==false || xFound==false && yFound==true) return false;
        }

        return true;
    }

}