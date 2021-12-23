
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// Used a queue to store the root
// Based on the size of the queue traversed the queue and then popped the element added it to list
// added the elements children to the queue

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1)
                    result.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// took the level
// if the size of the result list was equal to the level
// added the root val to that level
// Going right
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int lvl) {
        if (root == null)
            return;
        if (result.size() == lvl)
            result.add(root.val);
        dfs(root.right, lvl + 1);
        dfs(root.left, lvl + 1);

    }
}

// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// took the level
// if the size of the result list was equal to the level
// added the root val to that level
// Going left
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int lvl) {
        if (root == null)
            return;
        if (result.size() == lvl)
            result.add(root.val);
        else
            result.set(lvl, root.val);
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);

    }
}