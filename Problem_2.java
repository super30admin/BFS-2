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
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// store the level and parent in an variable and comapre at the end
// Your code here along with comments explaining your approach

// dfs solution

class Solution {
    TreeNode x_parent; TreeNode y_parent;
    int x_level; int y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        // null
        if(root == null) return false;
        dfs(root,x,y,0,null);
        return x_level == y_level && x_parent != y_parent;
    }
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        //base
        if(root == null ) return;
        //logic
        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }
        // left
        dfs(root.left,x,y, level+1,root);
        // right
        dfs(root.right,x,y, level+1,root);
    }
}

// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// store the level boolean at every level and check for the parent in between and values at the end of one level
// Your code here along with comments explaining your approach

// bfs solution

// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if( root == null ) return false;
//         Queue <TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             boolean x_found = false;
//             boolean y_found = false;
//             for( int i = 0; i < size ; i++){
//                 TreeNode cur = q.poll();
//                 if(cur.val == x) x_found = true;
//                 if(cur.val == y) y_found = true;
//                 if( cur.left != null && cur.right != null ){
//                     if( cur.left.val == x && cur.right.val == y ) return false;
//                     if( cur.left.val == y && cur.right.val == x ) return false;
//                 }
//                 if( cur.left != null){
//                     q.add(cur.left);
//                 }
//                 if( cur.right != null){
//                     q.add(cur.right);
//                 }
//             }
//             if(x_found && y_found) return true;
//             if(x_found || y_found) return false;
//         }
//       return false;
//     }
// }

