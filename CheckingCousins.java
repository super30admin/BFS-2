package BFS2;

// Time Complexity : O(n)
// Space Complexity : O(n)   //max number of leaf nodes;
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class CheckingCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();
        q.add(root);
        parentQ.add(null);

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean x_found = false;;
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                TreeNode currP = parentQ.poll();
                if(curr!=null)
                {
                    if(curr.val == x)
                    {
                        x_found = true;
                        x_parent = currP;
                    }
                    if(curr.val == y)
                    {
                        y_found = true;
                        y_parent = currP;
                    }

                    if(x_found && y_found) return x_parent != y_parent;

                    if(curr.left!=null)
                    {
                        q.add(curr.left);
                        parentQ.add(curr);
                    }
                    if(curr.right!=null)
                    {
                        q.add(curr.right);
                        parentQ.add(curr);
                    }
                }
            }
            if(x_found || y_found) return false;
        }

        return false;
    }
}
