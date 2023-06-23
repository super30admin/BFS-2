// Time Complexity - O(n) - for DFS
// Space Complexity - O(h) - h is the height of the tree - for DFS

// Time Complexity - O(n) - for BFS
// Space Complexity - O(n) - for BFS

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
    // BFS Implementation
 /*    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode curr = new TreeNode();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
            }
            result.add(curr.val);
            
        }
        return result;
    } */


        // DFS Implementation
        List<Integer> result;
        public List<Integer> rightSideView(TreeNode root) {
            result =  new ArrayList<>();
            helper(root,0);
            return result;
        
        }

        private void helper(TreeNode root,int level){

            // base
            if(root == null) return;

            if(result.size()==level){ // ensures every level only once element addition happens
                result.add(root.val);
            }

            helper(root.right,level+1);
            helper(root.left,level+1);
        }

}