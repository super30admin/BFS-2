// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
       
            result = new ArrayList<>();
            //level 0
            dfs(root, 0);
            return result;
        // BFS
//         TreeNode node = null;
//         if(root == null){
//             return result;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
            
//             for(int i = 0; i < size; i++){
//                 node = queue.poll();
//                 if(node.left != null){
//                     queue.add(node.left);
//                 }
//                 if(node.right != null){
//                     queue.add(node.right);
//                 }
                
//             }
//             result.add(node.val);
            
//         }
//        return result;
        
        
    }
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
        
    }
    
}