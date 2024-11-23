/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : Brute Force BFS - Level Order Traversal with two pointers for comparing left and right
// Time : O(n)
// Space : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();
                list.add(curr);
                if (curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            // after each level use two pointers to check if elements are equal
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                if (list.get(l) == null && list.get(r) == null) {
                    l++;
                    r--;
                } else if (list.get(l) == null || list.get(r) == null)
                    return false;
                else if (list.get(l).val != list.get(r).val)
                    return false;
                else {
                    l++;
                    r--;
                }
            }

        }

        return true;

    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : BFS - Level Order Traversal by add elements in pairs
// Time : O(n)
// Space : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            q.add(left.right);
            q.add(right.left);
            q.add(left.left);
            q.add(right.right);
        }
        return true;
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : DFS - Iterative solution
// Time : O(n)
// Space : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        while (!st.isEmpty()) {
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            st.add(left.right);
            st.add(right.left);
            st.add(left.left);
            st.add(right.right);
        }
        return true;
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : DFS - Recursive solution
// Time : O(n)
// Space : O(n)
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        this.flag = true;
        dfs(root.left,root.right);
        return flag;
    }

    public void dfs(TreeNode left, TreeNode right){
        // base
        if(left == null && right == null) return;

        // logic
        if(left == null || right == null){
            flag = false;
            return;
        }

        if(left.val!=right.val) {
            flag = false;
            return;
        }

        // recursion
        dfs(left.left, right.right);
        dfs(left.right,right.left);
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : DFS - Improved Recursive solution
// Time : O(n)
// Space : O(n)
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        this.flag = true;
        dfs(root.left,root.right);
        return flag;
    }

    public void dfs(TreeNode left, TreeNode right){
        // base case 1
        if(left == null && right == null) return;
        // base case 2
        if(left == null || right == null){
            flag = false;
            return;
        }
        // recursion
        dfs(left.left, right.right);

        if(left.val!=right.val) {
            flag = false;
            return;
        }
        if(flag)
        dfs(left.right,right.left);
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Approach : DFS - Recursive solution with boolean based recursion
// Time : O(n)
// Space : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right){
        // base case 
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val!=right.val) return false;
        boolean leftCase = dfs(left.left, right.right);
        boolean rightCase = dfs(left.right,right.left);
        return leftCase && rightCase;
    }

}