import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Using BFS Approach
Time Complexity -> O(N)
Space Complexity -> O(N)
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}

/*
Using DFS Approach
Time Complexity -> O(N)
Space Complexity -> O(H)
Since we have a right side we are moving right and procceding the steps
*/



class Solution1 {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
/*
Using DFS Approach
Time Complexity -> O(N)
Space Complexity -> O(H)
Here we are moving to teh left node first and then to the right node
*/



class Solution2 {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}