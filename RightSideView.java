import java.util.ArrayList;
import java.util.List;

/**
## Problem 1
Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
 
Time Complexity :   O (N) 
Space Complexity :  O (H)
Did this code successfully run on Leetcode :    Yes (199. Binary Tree Right Side View)
Any problem you faced while coding this :       No
 */

// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int depth, List<Integer> result){
        // base case
        if(root == null)
            return;
        
        // logic
        
        if(depth == result.size()){
            result.add(root.val);
        }
        dfs(root.right, depth+1, result);
        dfs(root.left, depth+1, result);
    }
}