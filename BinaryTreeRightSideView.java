
//Time complexity: O(n)

//Space : O(n)

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.remove();
                if (i == n) ans.add(temp.val);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
        List<Integer> result = sol.rightSideView(root);
        System.out.println(result);
    }
}
