// O(n) time, n is number of nodes
// O(d) space to keep queues, where d is tree diameter

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque(){{offer(root);}};
        ArrayDeque<TreeNode> currLevel = new ArrayDeque();
        List<Integer> right = new ArrayList();
        
        TreeNode node = null;
        while (!nextLevel.isEmpty()){
            currLevel = nextLevel.clone();
            nextLevel.clear();
            
            while (!currLevel.isEmpty()){
                node = currLevel.poll();

                if (node.left != null) nextLevel.offer(node.left);
                if (node.right != null) nextLevel.offer(node.right);
            }
            if (currLevel.isEmpty()) right.add(node.val);
        }
        return right;
    }
}