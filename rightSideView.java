
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
 * BFS appraoch
 * Tc --> O(n)
 * Sc --> O(n) for the Queue
 *
 */
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        //store the values in list and return the last value from each list
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ls.add(root.val);

        res.add(root.val);
        ls.clear();
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    ls.add(node.left.val);
                    q.add(node.left);
                }
                if (node.right != null) {
                    ls.add(node.right.val);
                    q.add(node.right);
                }
            }//fpr

            if (ls.size() > 0) {
                res.add(ls.get(ls.size() - 1));
            }
            ls.clear();
        }//while

        return res;

    }//method
}
