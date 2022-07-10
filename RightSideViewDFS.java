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
    
    
    /*
     *
     * In DFS, we recursively call helper with incremented level and adding left and right children.
     *
     * Time complexity: O(no.of nodes) -> Since we visit every node once.
     * Space complexity: O(no.of nodes on one side of the tree) ~= O(n)
     *
     */
    
    
    private List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        
        return result;
    }
    
    private void helper(TreeNode node, int level) {
        if(node == null) return;
        
        System.out.println("Node:"+node.val +" level:"+ level + " result:" + result);
        
        
        //If there is an element already present replacing element at that index
        if(level < result.size())
           result.set(level, node.val);
        else
            result.add(node.val);
        
        // Proceed adding left and right recursive calls.
        if(node.left != null)
            helper(node.left, level+1);
        
        if(node.right != null)
            helper(node.right, level+1);
        
        return;
    }
    
}
