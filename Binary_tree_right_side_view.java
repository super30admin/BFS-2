//Using BFS

//TC: O(n) where n is the total nodes in the tree
//SC: O(n)

//CODE:

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    result.add(curr.val);
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}

// Using DFS

// TC: O(n)
// SC: O(h) where h is the height of the tree , space used for recursion

// CODE:

// 1. calling right child first -> call right child first and add the first ele
// with that level to the list
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null)
            return;

        // logic
        if (result.size() == level) { // it means for that level there is no element so add it to the result
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

// 1. calling left child first -> call the left child first and keep on adding
// the ele with particular level to result . As soon a we encounter other
// element with same level , update the element in the result.
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null)
            return;

        // logic
        if (result.size() == level) { // it means for that level there is no element
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
