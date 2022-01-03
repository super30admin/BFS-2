// Time Complexity :O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use a class variable level, to keep track of visited level.
 * We will traverse tree using DFS approach and we will check if current level >= level visited so far.
 * If yes, then we add current node value to result list, increment visited level and go to next level.
 * While traversing we will go to right subtree first then to left subtree
 * Also we will increment visited level if we have process current level if it is not processed already
 * that is element of current level not added to result already.
*/


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
    int level;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        dfs(root, result, 0);
        return result;
        
//         Queue<TreeNode> q = new LinkedList();
//         q.add(root);
        
//         while(q.isEmpty() == false){
//             int size = q.size();
            
//             for(int i = 0; i < size;i++){
//                 TreeNode curr = q.poll();
//                 if(i == size-1){
//                     result.add(curr.val);
//                 }
//                 if(curr.left != null)q.add(curr.left);
//                 if(curr.right != null)q.add(curr.right);
//             }
//         }
        
//         return result;
    }
    
    private void dfs(TreeNode root, List<Integer> result, int cur_level){
        //base case
        if(root == null)return;
        
        //logic
        if(cur_level >= level){
           result.add(root.val);  
             level++;
        }
        dfs(root.right, result, cur_level + 1);
        dfs(root.left, result, cur_level + 1);
    }
}