/*
Time: O(N) where N is the number of nodes in the Tree
Space: O(N)
*/
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
class Problem1 {
    public List<Integer> rightSideView(TreeNode root) {
 
         List<Integer> res = new ArrayList();
 
         if (root == null)
             return res;
 
         Queue<TreeNode> q = new LinkedList();
         q.offer(root);
 
         while (!q.isEmpty()) {
             int size = q.size();
 
             for (int i = 0; i < size; i++) {
                 TreeNode cur = q.poll();
 
                 if (i == size - 1) // add the last node on every layer, to the result. For left view put 'if(i==0)'
                     res.add(cur.val);
 
                 if (cur.left != null)
                     q.offer(cur.left);
 
                 if (cur.right != null)
                     q.offer(cur.right);
             }
         }
 
         return res;
 
     }
 }