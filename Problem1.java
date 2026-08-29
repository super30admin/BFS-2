// DFS
// stack space o(n)
// time complexity o(n)
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
     List<Integer> result = new ArrayList<>();
     
    public List<Integer> rightSideView(TreeNode root) {
    

    helper(root,0);
   

    return result;
        
    }

    private void helper(TreeNode root, int height){
        if(root == null) { return;}

       if(height == result.size()){
        result.add(root.val);
    }
    result.set(height, root.val);
   
        
        helper(root.left, height+1);
        
helper(root.right, height+1);


    }
}
