// 199. Binary Tree Right Side View

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

// BFS Solution 
 
class Solution {
    List<Integer> out = new LinkedList<>();
   public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
       if (root == null) return list;
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       q.add(null);
       while (!q.isEmpty()) {

           TreeNode node = q.poll();
           if (node == null) return list;
           if (node.left != null)
               q.add(node.left);
           if (node.right != null)
               q.add(node.right);
           if (q.peek() == null) {
               q.poll();
               q.add(null);
               list.add(node.val);
           }
       }
       return list;
   }
}
//BFS Solution ends here 


/*

Complexity Analysis

Time complexity: 
O(N) since one has to visit each node.

Space complexity: 
O(D) to keep the queues, where D is a tree diameter.
*/