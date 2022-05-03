import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1 {
    public class TreeNode {
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
//DFS
//    TC : O(n)
//    Sc : O(n)

    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;

        result = new ArrayList<>();

        helper(root, 0);
        return result;

    }

    private void helper(TreeNode root, int index) {
        //base case
        if (root == null) return;
        //logic

        if (result.size() == index) {
            result.add(root.val);
        }
        result.set(index, root.val);

        helper(root.left, index + 1);
        helper(root.right, index + 1);
        //index --;
    }

    //BFS
//    TC : O(n)
//    Sc : O(n)

    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int index = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (i == size - 1) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
        }
        return result;
    }
}
