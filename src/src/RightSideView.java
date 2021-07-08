import java.util.*;

public class RightSideView {

    /*
    TC : O(N) where N is the number of nodes in the tree
    SC : O(2^h) where h is the height of the tree as the queue will have maximum that many nodes in the queue at any point of time
    LC : yes
    Provlems: No
     */

    /**
     * Use the iterative approach and queue's size to reach the last element at a level, ie the right most element
     *
     * @param root
     * @return
     */

    public List<Integer> rightSideView_queue_approach(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1)
                    result.add(node.val);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }


        }

        return result;
    }


    /*
     TC : O(N) where N is the number of nodes in the tree
     SC : 0(N) for the recursive stack
     LC : Yes
     Problems : No
     */

    /**
     * Used the recursive approach and gave the call to left child first but overwrote the value in the result list
     * So, eventually we'll have the right most child in the result list
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView_dfs_recursion_leftchild_first(TreeNode root) {

        if (root == null)
            return result;

        helper_dfs_recursion_leftchild_first(root, 0);

        return result;
    }

    public void helper_dfs_recursion_leftchild_first(TreeNode root, int level) {

        if (root == null)
            return;

        if (result.size() == level)
            result.add(root.val);

        else
            result.set(level, root.val);
        if (root.left != null) helper_dfs_recursion_leftchild_first(root.left, level + 1);
        if (root.right != null) helper_dfs_recursion_leftchild_first(root.right, level + 1);
    }


     /*
     TC : O(N) where N is the number of nodes in the tree
     SC : 0(N) for the recursive stack
     LC : Yes
     Problems : No
     */

    /**
     * Used the recursive approach and gave the call to right child first.
     * Used the variable level and compared it with result size. If they are equal, we will add the child node as the call was sent to the rightmost child first
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView_dfs_recursion_rightchild_first(TreeNode root) {

        if (root == null)
            return result;

        helper_dfs_recursion_rightchild_first(root, 0);

        return result;
    }

    public void helper_dfs_recursion_rightchild_first(TreeNode root, int level) {

        if (root == null)
            return;

        if (result.size() == level)
            result.add(root.val);
        if (root.right != null) helper_dfs_recursion_rightchild_first(root.right, level + 1);

        if (root.left != null) helper_dfs_recursion_rightchild_first(root.left, level + 1);


    }

}
