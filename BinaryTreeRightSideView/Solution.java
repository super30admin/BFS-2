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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Do a level order traaversal. Only change is instead of adding all nodes to the result, add just the last node at each level.
 */

/**
 * DFS with left first
 */

class Solution {

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {

        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int depth) {

        if(root == null) return;

        if(result.size() == depth)
            result.add(root.val);
        else
            result.set(depth, root.val);

        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}


/**
 * DFS
 */
/*class Solution {

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {

        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int depth) {

        if(root == null) return;

        if(result.size() == depth)
            result.add(root.val);

        helper(root.right, depth+1);
        helper(root.left, depth+1);
    }
}*/


/**
 * BFS
 */
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {

                TreeNode node = q.poll();

                if(i == size-1)
                    result.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
        }

        return result;
    }
}*/
