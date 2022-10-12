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
//Time: O(n)
//Space: O(h)
//dfs
// class Solution {
//     TreeNode x_parent, y_parent;
//     int x_lvl, y_lvl;
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root == null || x == y)
//             return false;
        
//         dfs(root, x, y, null, 0);
        
//         return x_parent != y_parent && x_lvl == y_lvl;
//     }
    
//     private void dfs(TreeNode root, int x, int y, TreeNode parent, int lvl){
//         if(root == null)
//             return;
        
//         if(x == root.val){
//             x_parent = parent;
//             x_lvl = lvl;
//         }
//         if(y == root.val){
//             y_parent = parent;
//             y_lvl = lvl;
//         }
//         if(x_parent == null || y_parent == null){
//             dfs(root.left, x, y, root, lvl + 1);
//             dfs(root.right, x, y, root, lvl + 1);
//         }
        
//     }
// }
//Time: O(n)
//Space: O(n)
//bfs
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == y)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x)
                    x_found = true;
                if(curr.val == y)
                    y_found = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                
            }
            if(x_found == true && y_found == true)
                return true;
            if(x_found == true || y_found == true)
                return false;
        }
        
        
        return false;
    }
}

