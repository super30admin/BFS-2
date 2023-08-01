//Cousins-in-binary-tree
//TC:O(n)
//SC:O(n)
import java.util.LinkedList;
import java.util.Queue;

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

class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root==null)
        {
            return false;
        }
        //Queue for children
        Queue<TreeNode> cq=new LinkedList<>();
        //Queue for parents
        Queue<TreeNode> pq=new LinkedList<>();
        cq.add(root);
        pq.add(null);



        while(!cq.isEmpty())
        {
            int size=cq.size();
            TreeNode xparent=null;
            TreeNode yparent=null;
            boolean xfound=false;
            boolean yfound=false;
            for(int i=0;i<size;i++)
            {
                TreeNode child=cq.poll();
                TreeNode parent=pq.poll();
                if(child!=null)
                {
                    if(child.val==x)
                    {
                        xparent=parent;
                        xfound=true;
                    }
                    if(child.val==y)
                    {
                        yparent=parent;
                        yfound=true;
                    }
                    //x and y not found at that level , we move to next level

                    if(child.left!=null)
                    {
                        cq.add(child.left);
                        pq.add(child);
                    }
                    if(child.right!=null)
                    {
                        cq.add(child.right);
                        pq.add(child);
                    }
                }

            }//end for
            //both nodes found at same level and with diff parents
            if(xfound==true && yfound==true && xparent!=yparent)
                return true;

        }//end while

        return false;
    }
}