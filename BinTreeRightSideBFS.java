// Time Complexity :O(n) where n is the number of nodes in the tree
// Space Complexity :   O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We will do level order traversal and add the last element of each level to the result list. 
// We will use a queue to do level order traversal and keep track of the size of the queue at each level to know when we are at the end of the level.
// We will add the left and right children of the current node to the queue for the next level.
// 

// Your code here along with comments explaining your approach
import java.util.*;


 //Definition for a binary tree node.
 public class BinTreeRightSideBFS {
      int val;
      BinTreeRightSideBFS left;
      BinTreeRightSideBFS right;
 
      BinTreeRightSideBFS() {}
 
      BinTreeRightSideBFS(int val) {
          this.val = val;
      }
 
      BinTreeRightSideBFS(int val, BinTreeRightSideBFS left, BinTreeRightSideBFS right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {

    public List<Integer> rightSideView(BinTreeRightSideBFS root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<BinTreeRightSideBFS> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {

            int count = que.size();

            for (int i = 0; i < count; i++) {

                BinTreeRightSideBFS curr = que.poll();

                if (i == count - 1) {
                    res.add(curr.val);
                }

                if (curr.left != null) {
                    que.offer(curr.left);
                }

                if (curr.right != null) {
                    que.offer(curr.right);
                }
            }
        }

        return res;
    }
}