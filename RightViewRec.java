
/**
 * Time complexity is O(n)
 * Space complexity is O(1) as we are not using any extra space for solving the problem
 */

import java.util.*;

public class RightViewRec {
    class Solution {
        List<Integer> result = new ArrayList<Integer>();

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null)
                return result;

            helper(root, 1);
            return result;
        }

        public void helper(TreeNode root, int level) {
            if (root == null)
                return;
            if (result.size() < level)
                result.add(root.val);
            helper(root.right, level + 1);
            helper(root.left, level + 1);
        }
    }
}
