/** Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
* Recursive solution
* TC O(N) SC O(h) for the recursive stack
* Code was submitted on leetcode
*/
class Solution {
    List<Integer> right = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return right;
        dfs(root, 0);
        return right;
    }
    private void dfs(TreeNode root, int level)
    {
        if (root == null)
            return;
        if (right.size() == level)
        {
            right.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}

/** Iterative solution
* Code was submitted on leetcode
* TC O(N) SC O(H)
*/
class Solution {
    List<Integer> right = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return right;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()) {
            int size = level.size();
            int last = 0;
            for (int i = 0; i< size; i++) {
                TreeNode node = level.remove();
                last = node.val;
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                } 
            }
            right.add(last);
        }
       
        
        return right;
    }
}
