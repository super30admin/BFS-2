// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
This program returns the rightmost node values at each level of a binary tree.
 It performs a level-order traversal using a queue, keeping track of the number of nodes at each level.
  During traversal, it adds the value of the last node in every level to the result list.
  The approach ensures that only the visible nodes from the right side of the tree are captured.


* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        if(root==null)
            return ans;

        Queue<TreeNode> queue=new LinkedList<>();
        //ans.add(root.val);
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                if(i==size-1)
                    ans.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
        }
        return ans;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}