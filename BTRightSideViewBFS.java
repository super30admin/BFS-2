//Time Complexity - O(n)
//Space complexity - O(h) - height of the tree

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
      result = new ArrayList<>();
      //BFS solution
      Queue <TreeNode> q = new LinkedList<>();
      q.add(root);
      
      while(!q.isEmpty()) {
        int size = q.size();
        //add childeren to the queue
        for(int i=0; i< size;i++) {
          TreeNode curr = q.poll();
          System.out.println("size: " + size + " i: " + i);
          //if its last node then add it to the result
          if(i == size-1) {
            result.add(curr.val);
          }
          //add left and right children in queue
          if(curr.left!=null) q.add(curr.left);
          if(curr.right!=null) q.add(curr.right);
        }
      }
        
      return result;
    }
}