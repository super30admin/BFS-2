//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> lis;

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node1.right = node3;
        node2.right = node4;
        root.left = node1;
        root.right = node2;
        List<Integer> result = sol.treeRightSide(root);
        System.out.println(result);
    }
    public List<Integer> treeRightSide(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        lis = new ArrayList<>();
        q.add(root);

        bfs(root, q, lis);

        return lis;
    }

    private void bfs(TreeNode root, Queue<TreeNode> q, List<Integer> lis) {

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(i == size - 1) {
                    lis.add(curr.val);
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}
