// Time complexity: O(N) as we are traversing all nodes of the tree
// Space complexity: O(H) as we maintain a stack which can contain as many nodes as the height of tree at any given time. Worst case O(N) if the tree is skewed

// Approach: use DFS. Same as level order traversal recursive solution. Just a minor change. Maintain a local depth variable. start the dfs from left to right and make sure to replace the value in the result array at that specific index so that we get the right most node's value in the result.

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int depth) {
        // base
        if (root == null) return;
        
        // logic
        if (depth == result.size()) {
            result.add(root.val);
        }
        else {
            result.set(depth, root.val);
        }
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}