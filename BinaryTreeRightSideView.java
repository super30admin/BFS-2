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
//Time complexity: O(n)
//Space complexity: O(n)
//bfs
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root == null)
//             return new ArrayList<>();
        
//         List<Integer> result = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode curr = q.poll();
//                 if(i == size - 1)
//                     result.add(curr.val);
//                 if(curr.left != null)
//                     q.add(curr.left);
//                 if(curr.right != null)
//                     q.add(curr.right);
//             }
            
//         }
//         return result;
//     }
// }

//Time complexity: O(n)
//Space complexity: O(h)
//dfs right first
// class Solution {
//     List<Integer> result;
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root == null)
//             return new ArrayList<>();
        
//         result = new ArrayList<>();
        
//         dfs(root, 0);
        
//         return result;
//     }
    
//     private void dfs(TreeNode root, int lvl){
//         if(root == null)
//             return;
//         if(lvl == result.size())
//             result.add(root.val);
//         dfs(root.right, lvl + 1);
//         dfs(root.left, lvl + 1);
//     }
// }

//Time complexity: O(n)
//Space complexity: O(h)
//dfs left first
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root == null)
            return;
        
        if(lvl == result.size())
            result.add(root.val);
        else
            result.set(lvl, root.val);
        
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}
