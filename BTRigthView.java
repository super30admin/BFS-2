// TC : O(N)
// SC: O(H)
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
    ArrayList<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {

        // base case
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();
        dfs(root,0);
        return result;

    }

    private void dfs (TreeNode root, int lvl) {
        // base case
        if (root == null) return;

        // add element if it has not been added before
        if (lvl == result.size()) {
            // add blindly
            result.add(root.val);
        } else {
            // replace
            result.set(lvl, root.val);
        }

        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);

    }

//     public List<Integer> rightSideView(TreeNode root) {

//         // base case
//         if (root == null) return new ArrayList<>();

//         List<Integer> result = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()) {
//             int size = q.size();

//             for (int i=0;i<size; i++) {
//                 TreeNode curr = q.poll();
//                 if (i == size -1) {
//                     result.add(curr.val);
//                 }
//                 if (curr.left != null) {
//                     q.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     q.add(curr.right);
//                 }
//             }
//         }
//         return result;
//     }
}
