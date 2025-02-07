import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : later realized two nodes can't have same parent

public class rightSideOfTree {
 
        ArrayList<Integer> res = new ArrayList<>();
    
        private void helper(TreeNode root,int level) {
            if(root == null) return;
    
            if(level == res.size()) res.add(root.val);
    
            helper(root.right,level+1);
            helper(root.left,level+1);
        }
    
        public List<Integer> rightSideView(TreeNode root) {
            helper(root,0);
            return res;
        }
}
