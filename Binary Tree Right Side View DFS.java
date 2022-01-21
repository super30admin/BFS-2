// Time Complexity : O(n)
// Space Complexity : O(h)
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
        // call the recursive function
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        // base
        // if leaf node is found then return
        if(root == null) return;
        
        // logic
        // if level ie equal to the size of the result then add that node's value to the list
        if(level == result.size()){
            result.add(root.val);
        } 

        // call recursive function on the right child node first
        dfs(root.right, level + 1);
        // st.pop()
        // call recursive function on the left child node
        dfs(root.left, level + 1);
    }
}


// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     List<Integer> result;
//     public List<Integer> rightSideView(TreeNode root) {
//         result = new ArrayList<>();
//         dfs(root, 0);
//         return result;
//     }
    
//     private void dfs(TreeNode root, int level){
//         // base
//         if(root == null) return;
        
//         // logic
//         // if level ie equal to the size of the result then add that node's value to the list
//         if(level == result.size()){
//             result.add(root.val);
//         } 
//         // else replace the node's value
//         else{
//             result.set(level, root.val);
//         }
        
//         // call recursive function on the left child node first
//         dfs(root.left, level + 1);
//         // st.pop()
//         // call recursive function on the right child node 
//         dfs(root.right, level + 1);
//     }
// }