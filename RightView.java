
/**
 * Time complexity is O(n) as we are visiting every element of the tree
 * Space complexity will be O(n/2) as at a certain point of time total number of elements
 * inside the queue will be only leaves of the tree making it nearly n/2 
 */

import java.util.*;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if (root == null)
            return lst;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            TreeNode current = null;
            for (int i = 0; i < size; i++) {
                current = qu.remove();

                if (current.left != null)
                    qu.add(current.left);
                if (current.right != null)
                    qu.add(current.right);
            }
            lst.add(current.val);
        }
        return lst;
    }
}
