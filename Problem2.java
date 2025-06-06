// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//parent should not be same, for x and y to be found, if found then return false,
//else when found check if level is same.
//use queue to implement level order traversal.

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
 //iterative
 //using queue for lever order traversal(bfs)
// class Solution {
    
//     public boolean isCousins(TreeNode root, int x, int y) {
//         Queue<TreeNode> q = new LinkedList<>();
//         // Queue<TreeNode> pq= new LinkedList<>();
//         // pq.add(null);
//         q.add(root);
//         // TreeNode parent_x=null;
//         // TreeNode parent_y=null;
//         while(!q.isEmpty()){
//             int size=q.size();
//             boolean xFound = false;
//             boolean yFound = false;
//             for(int i=0; i<size; i++){
//                 TreeNode cur=q.poll();
//                 // TreeNode parent=pq.poll();
//                 if(cur.val==x){
//                     // parent_x=parent;
//                     xFound=true;
//                 }
//                 if(cur.val==y){
//                     // parent_y=parent;
//                     yFound=true;
//                 }
//                 if(cur.left!=null && cur.right!=null){
//                     if((cur.left.val==x ||cur.left.val==y ) && (cur.right.val==x ||cur.right.val==y )) return false;}
//                 if(cur.left!=null){
//                     // pq.add(cur);
//                     q.add(cur.left);
//                 }
//                 if(cur.right!=null){
//                     // pq.add(cur);
//                     q.add(cur.right);
//                 }
//             }
//             if(yFound && xFound) return true;
//             if(yFound || xFound) return false;
//         }
//         return false;
//     }
// }
//dfs
class Solution {
    TreeNode parent_x;
    TreeNode parent_y;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.parent_x=null;
        this.parent_y=null;
        this.depth_x=0;
        this.depth_y=0;
        dfs(root,0,null,x,y);
        return depth_x==depth_y && parent_x!=parent_y;
    }
    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
        //base
        if(root==null) return;
        //logic
        if(root.val==x){
            depth_x=depth;
            parent_x=parent;
        }
        if(root.val==y){
            depth_y=depth;
            parent_y=parent;
        }
        if(parent_x!=null && parent_y!=null) return;
        dfs(root.left, depth+1, root, x,y);
        dfs(root.right, depth+1, root, x,y);
    }

}