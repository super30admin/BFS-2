// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We are using a BFS approach here.We iterate at all levels and whenever we see the right most element at any level , we add that to the result .

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
        
      List<Integer> result = new ArrayList<>();
      
      if(root == null)
      {
        return result;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      
      while(!queue.isEmpty())
      {
            int size = queue.size();
        
            for(int i = 0; i < size; ++i) 
            {
                TreeNode front = queue.poll();
                //right most element at any level add it to the result
                if( i == size-1)
                {
                  result.add(front.val);
                }


                 if(front.left!=null)
                {
                  queue.add(front.left);
                }
                if(front.right!=null)
                {
                  queue.add(front.right);
                }
            }
      }
      return result;
    }
}