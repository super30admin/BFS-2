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

// TC: O(N)
// SC: O(N)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        queue.add(root);
        
        int count = 0;
        while(!queue.isEmpty()) {
            count = 0;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.peek();
                count++;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                queue.poll();
                if(count == size) {
                    al.add(curr.val);
                }
            }
        }
        return al;
    }
}
