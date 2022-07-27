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

// //Time Complexity: O(n).
// //Space Complexity:  O(n). 
// class Solution {
//     int x_depth;
//     int y_depth;
//     TreeNode x_parent;
//     TreeNode y_parent;
    
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root == null) return false;
        
//         dfs(root, 0, null,x ,y);
//         return x_depth == y_depth && x_parent != y_parent;
        
//     }
        
        
//     private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
//         //base case: 
//         if(root == null) return;
        
        
//         //logic:
//         if(root.val == x){
//             x_depth = depth;
//             x_parent = parent; 
//         }
        
//         if(root.val == y){
//             y_depth = depth;
//             y_parent = parent;
//         }
        
//         dfs(root.left, depth+1, root, x, y);
//         dfs(root.right, depth+1, root, x, y);
//     } 
// //         Queue<TreeNode> oq = new LinkedList<>();
        
// //         oq.add(root);
// //         while(!oq.isEmpty()){
// //             int size = oq.size();
// //             for()
        
// }


class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> oq = new LinkedList<>();
        
        oq.add(root);
        while(!oq.isEmpty()){
            int size = oq.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = oq.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                     if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                
                if(curr.left != null)
                    oq.add(curr.left);
                
                if(curr.right != null)
                    oq.add(curr.right);
            }
            
            if(x_found == true && y_found == true)
                return true;
            if(x_found == true || y_found == true)
                return false;
        }
        return false; 
    }
}