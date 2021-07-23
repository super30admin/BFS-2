// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//this is the DFS approach with left first traversal

import java.util.*;

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
         result = new ArrayList<Integer>();
        
        if(root == null)
            return result;
        
        helper(root, 0);
        return result;
 
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        
        if(result.size() == level){
            result.add(root.val); //new level
        }
        else{
            result.set(level, root.val); //found new rightmost node at that level so we replace
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}