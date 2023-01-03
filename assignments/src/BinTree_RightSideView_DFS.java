import java.util.*;

public class BinTree_RightSideView_DFS {

    // Approach: Use DFS and visit right side first always. Keep adding nodes to list everytime level = size.
    // When the left nodes are visited, level won't match size and so they are not added.
    // Time: O(n) in case of a skewed right side only tree
    // Space: O(H) height of the tree. Worst case H = n
    List<Integer> rightSideList = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) return rightSideList;
        getRightSideNodes(root, 0);
        return rightSideList;
    }

    void getRightSideNodes (TreeNode root, int level) {
        if (root != null && level == rightSideList.size()) rightSideList.add(root.val);

        if (root.right != null) getRightSideNodes(root.right, level+1);
        if (root.left != null) getRightSideNodes(root.left, level+1);
    }
}