// TC: O(n)
// SC: O(2^h) => O(2^logn) => O(n)
// where h is the height of the tree & n is the number of nodes in the tree


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null)
            q.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                TreeNode node = q.poll();
                if (len == 1)
                    ans.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                len--;
            }
        }
        return ans;
    }
}
