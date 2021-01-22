// Time Complexity : O(V) For both approaches, we will essentially go over each element V
// Space Complexity : BFS uses an additional Queue that can conatain at most n/2 elements. n/2 would be number of leaf elements in a complete binary TreeNode
// Space Complexity : DFS uses a stack internally for recursion, without considering it O(1) space complexity.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Level order traversal and add the last element of that level.

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
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;

        //dfs(root, 0);
        bfs(root);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) return;

        if(depth == result.size())
            result.add(root.val); //Add the last element

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);

    }

    private void bfs(TreeNode root) {

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode curr = q.poll();
                if(i == size - 1) {
                    result.add(curr.val); //Add the value in result only for the last element for right side rightSideView
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

        }

    }
}
