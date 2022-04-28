import java.util.LinkedList;
import java.util.Queue;

public class CousinsDFS {

    // TC: O(n) n - number of nodes in tree
    // SC: O(n)  since in the worst case we'll be storing n nodes in a queue
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        boolean x_found = false, y_found = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if this node has either x or y. If yes, set the corresponding flag to true
                if(current.val == x) x_found = true;
                if(current.val == y) y_found = true;

                // Now, check whether the children of this node are x & y or not.
                // If yes, then return false because cousin nodes should not have same parent
                if(current.left != null && current.right != null) {
                    if(current.left.val == x && current.right.val == y) return false;
                    if(current.left.val == y && current.right.val == x) return false;
                }


                // If none of the above conditions match that means we didn't find x & y
                // Put the children node of the current node into the queue and continue the search
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            // As soon as we are done with current level, check whether do we have any match for x & y
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }

        return false;
    }
}
