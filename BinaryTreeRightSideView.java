// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
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

// DFS APPROACH
class Solution {
  List<Integer> result;
  public List<Integer> rightSideView(TreeNode root) {
    result = new ArrayList<>();
    bfs(root, 0);
    return result;
  }

  void bfs(TreeNode root, int level) {
    if(root == null) return;

    // If size of result is equal to the present level, add the first value.
    if(result.size() == level) {
      result.add(root.val);
    }
    // Call right first, then left.
    bfs(root.right, level+1);
    bfs(root.left, level+1);
  }
}

// BFS APPROACH
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                if(i == size-1) result.add(current.val);
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
        }

        return result;
    }
} */