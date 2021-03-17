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
    public boolean isCousins(TreeNode root, int x, int y) {
      
      if(root==null)
      {
        return false;
      }
      //using a pair class to store the node and value of parent
      Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
      queue.add(new Pair<TreeNode,Integer>(root,-1));
      
      while(!queue.isEmpty())
      {
        int size = queue.size();
        
        int parentX = -1;
        int parentY = -1;
        //start processing a level of the tree
        for(int i=0;i<size;i++)
        {
          Pair<TreeNode,Integer> front = queue.poll();
          

          //get the current node
          TreeNode node = front.getKey();
          //get the parent of the current node
          int parent = front.getValue();

          //capturing the parents
          if(node.val==x)
          {
            parentX = parent;
          }
          if(node.val==y)
          {
            parentY = parent;
          }
          
          //add the current node and the parent to queue
          if(node.left!=null)
          {
            queue.add(new Pair<TreeNode,Integer>(node.left,node.val));
          }
          if(node.right!=null)
          {
            queue.add(new Pair<TreeNode,Integer>(node.right,node.val));
          }
        }
        //the case where we have found if the input x & y are cousins
        if(parentX!=-1 && parentY!=-1 && parentX != parentY)
        {
          return true;
        }
        
      }
        return false;
    }
}