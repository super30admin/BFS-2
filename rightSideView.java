//TC: O(N)
//SC: O(N)
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
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;
        
//         List<Integer> result = new ArrayList<>();
//         if(root == null)
//             return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             int sz = queue.size();
            
//             for(int i=0; i<sz; i++) {
//                 TreeNode curr = queue.poll();
//                 if(i == sz-1) {
//                     result.add(curr.val);
//                 }
//                 if(curr.left != null) queue.add(curr.left);
//                 if(curr.right != null) queue.add(curr.right);
//             }
//         }
//         return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null)
            return;
        
        
        if(result.size() == level) {
            result.add(root.val);
        }else {
            result.set(level, root.val);
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        // if(result.size() == level)
        //     result.add(root.val);
        // dfs(root.right, level+1);
        // dfs(root.left, level+1);
    }
}