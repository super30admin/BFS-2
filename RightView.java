/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /**
 This Java solution generates the right side view of a binary tree:

Initialize an empty list (res) to store the right side view.
Perform a depth-first search (dfs) starting from the right child, updating the result list (res) with the first encountered node at each level.
Return the final result list.
Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once during the depth-first search.
Space Complexity: O(H) - where H is the height of the binary tree. The space used by the recursive call stack is proportional to the height of the tree. 
In the worst case, the height is O(N), making the space complexity O(N).
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int level, List<Integer> res){
         if(root == null) return ;
         if(level == res.size()) res.add(root.val);
         dfs(root.right, level+1, res);
         dfs(root.left, level+1, res);


    }
}