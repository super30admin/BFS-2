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
// Time Complexity: We are traversing all the nodes providing O(n) time complexity
// Space Complexity: additional Datastructure queue used, O(n)
// Did you complete it on leetcode: Yes
// Any problems faced: no

// Write your approach here
// Idea here is to perform level order traversal using BFS by using queue datastructure
// at each level we maintain a size and iterate through that size to add child nodes to queue
// also we take the last element in that size to add to result
// at each level when we added rightmost value to result we get right side view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root== null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        q.offer(root);
        // li.add(root.val);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i< size; i++) {
                TreeNode curr = q.poll();
                if(i==size-1) {
                    li.add(curr.val);
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        return li;
    }
}