// Time Complexity : O(n)
// Space Complexity : O(n) - itrartive, O(h) - recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Use queue to store nodes for each level.
// poll nodes as per size of q for each level iteration and save it in result list for each level.
// save right side of tree when for loop reaches at the end element. 
// for recursive, keep in mind of recursive call order and save result only for first time at each level  

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
//Iterative
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root == null){
//             return new ArrayList<>();
//         }

//         Queue<TreeNode> q = new LinkedList<>();
//         List<Integer> res= new ArrayList<>();

//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();

//             for(int i=0; i<size; i++){
//                 TreeNode node = q.poll();
//                 if(i == size-1){
//                     res.add(node.val);
//                 }
//                 if(node.left != null){
//                     q.add(node.left);
//                 }
//                 if(node.right != null){
//                     q.add(node.right);
//                 }
//             }
//         }
//         return res;
//     }
// }

// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        int size = res.size();
        if(size == level){
            res.add(node.val);
        }
        dfs(node.right, level+1); // order is important
        dfs(node.left, level+1);   
    }
}