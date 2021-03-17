/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {  
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        //if an element from new level add to result
        if(result.size() == level){
            result.add(root.val);
        }else{//if it from already existing level , replace the value
            result.set(level, root.val);
        }
        
        //call left sub tree and then right sub tree
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}

// Time Complexity: O(n)
// Space Complexity : O(1)