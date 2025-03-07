// Time Complexity : O(n) n is the number of nodes as, we are visiting all the nodes in the tree.
// Space Complexity : O(n) using a queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


 //Definition for a binary tree node.
 import java.util.*;
  public class RightView {
      int val;
      RightView left;
      RightView right;
      RightView() {}
      RightView(int val) { this.val = val; }
      RightView(int val, RightView left, RightView right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 

class Solution {
    public List<Integer> rightSideView(RightView root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<RightView> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            int size = que.size();
            for(int i=0; i<size; i++)
            {
                RightView node = que.poll();
                if(i==size-1)
                    result.add(node.val);
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right); 
            }
        }
        return result;
    }
}