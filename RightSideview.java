//DFS
class RightSideview {


    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    public void helper(TreeNode node, int level, List<Integer> result)
    {
        if(node == null) return;

        if(level == result.size()){
            result.add(node.val);
        }
        helper(node.right, level+1, result);
        helper(node.left, level+1, result);

    }
}

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
//BFS
 class Solution {
     public List<Integer> rightSideView(TreeNode root) {

         if (root == null) return new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         List<Integer> result = new ArrayList<>();


         queue.add(root);

         while(!queue.isEmpty())
         {
             int n = queue.size();
             for(int i = 0; i < n; i++)
             {
                 TreeNode temp = queue.poll();
                 if(temp.left != null) queue.add(temp.left);
                 if(temp.right != null) queue.add(temp.right);

                 if(i == n-1)
                 {
                     result.add(temp.val);

                 }

             }

         }
         return result;

     }
 }