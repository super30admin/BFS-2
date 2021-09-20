
/**
 * Time complexity is O(n) - visiting every single node - Space complexity is O(n)
 * - no extra memeory is used
 * 
 * Problem is to validate the given cousins in the tree. Using depth first in
 * the recursive manner we can traverse through the tree and store the parents
 * and levels in variables and compaire them at the end
 */

import java.util.*;

public class CousinsBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y || root == null)
            return false;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        boolean x_found = false;
        boolean y_found = false;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = qu.poll();
                if (current.val == x)
                    x_found = true;
                if (current.val == y)
                    y_found = true;
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y)
                            || (current.left.val == y && current.right.val == x))
                        return false;
                }

                if (current.left != null)
                    qu.add(current.left);
                if (current.right != null)
                    qu.add(current.right);
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;
    }
}
