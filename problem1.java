//199 Binary Tree Right Side View
// solved on leetcode
// Time Complexity - O(n)
// Space Complexity - O(n)


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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        if(root==null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        
        
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeNode curr= new TreeNode();
            for(int i=0;i<size;i++){
                curr= queue.poll();
                
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            result.add(curr.val);
            
        }
        return result;
    }
}