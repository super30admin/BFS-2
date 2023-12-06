// Time Complexity : O(N)
// Space Complexity : O(H) worsst O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Explain your approach: this problem can be done using level order traversal, i.e. BFS, where we keep track 
// of the size of each level and if index == size - 1, i.e last element in level, add that elem to result
// Using DFS, there are 2 ways, preorder with Root - Right - Left and when result size == level, add root.val
// or Root - Left - Right, and we overwrite the value at a particular level after the right recrusive call

import java.util.*;
public class prob1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        if(root == null) return;
        if(level == result.size()){
            result.add(root.val);  
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        result.set(level, root.val);
        
    }
    
}
}
