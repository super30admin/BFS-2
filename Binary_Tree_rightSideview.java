// --> Time: O(n). Space: O(h) recursion (O(n) worst-case); O(n) total including the output list.

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_rightSideview {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level) {
        // base case 

        if(root == null) return;

        // logic
        if(result.size() == level) {
            result.add(root.val); //
        } else {
            result.set(level, root.val);
        }
        

        helper(root.left, result, level+1);

        helper(root.right, result, level+1);
    }
    
}
