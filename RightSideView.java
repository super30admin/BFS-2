/*
* Approach:
*  1. Apply DFS in reverse order like root, right, left.
* 
*  2. Add the elements into result by comparing the size with levels.
* 
*  3.At each level, we should add only one element. 
        so, if result.size == level then we should add the current node val.
        if not just proceed forward.
* 


If we are following the same order: root, left, right,
    then try replacing the value if result.size === level

    
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    exploring all nodes.
* 
* Space Complexity: O(h) === O(n)
    height of the tree 
* 
*/

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null)
            return;
        
        if(result.size() == level)  
            result.add(root.val);
        else
            result.set(level, root.val);
        
        dfs(root.left, level+1);
        
        dfs(root.right, level+1);
    }
}
