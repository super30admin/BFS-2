// Time Complexity : O(n) n is the number of nodes as, we are visiting all the nodes in the tree.
// Space Complexity : O(n) using a queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Definition for a binary tree node.
 import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode[]> que = new LinkedList<>();
        que.offer(new TreeNode[]{root, null});

        while(!que.isEmpty())
        {
            int size = que.size();
            boolean foundOnce = false;
            int foundParent = -1;
            for(int i=0; i<size; i++)
            {
                TreeNode[] pair = que.poll();
                if(foundOnce && (pair[0].val == x || pair[0].val == y))
                   return (foundParent != pair[1].val) ?  true : false;
                if(pair[0].val == x || pair[0].val == y)
                {
                    foundParent = pair[1] == null ? -1 : pair[1].val;
                    foundOnce = true;
                }
                
                if(pair[0].left != null)
                    que.offer(new TreeNode[]{pair[0].left, pair[0]});
                if(pair[0].right != null)
                    que.offer(new TreeNode[]{pair[0].right, pair[0]});
            }
            if(foundOnce)
                return false;
        }
        return false;
    }
}