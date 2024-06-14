/* 
    LC - 199. Binary Tree Right Side View
    TC - o(n)
    SC - o(n) - denotes the queue size
*/

// BFS Approach

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
                if(i == len-1) {
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}

/* 
    TC - o(n)
    SC - o(h) - height of the tree
*/

// DFS Approach 1 (Traditional - did the left recursive then did the right recursive. using the level parameter to keep track of level)

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0); // passing level as second param
        return result;
    }
    public void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

// DFS Approach 2 (did the right recursive then did the left recursive)

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0); // passing level as second param
        return result;
    }
    public void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}