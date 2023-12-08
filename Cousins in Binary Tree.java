// Time Complexity :O(N),O(N)
// Space Complexity :O(h),O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    TreeNode xParent;
    TreeNode yParent;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.xParent= null;
        this.yParent = null;
        this.xLevel=-1;
        this.yLevel=-1;
        helper(root,x,y,0,null);
        return xLevel==yLevel && xParent!=yParent;

    }
    public void helper(TreeNode root,int x,int y,int level,TreeNode parent)
    {
        if(root == null)
        return;
        if(root.val ==x)
        {
            xParent= parent;
            xLevel=level;
        }

        if(root.val ==y)
        {
            yParent= parent;
            yLevel=level;
        }
        if(xParent==null || yParent==null)
        helper(root.left,x,y,level+1,root);

        if(xParent==null || yParent==null)
        helper(root.right,x,y,level+1,root);




        //BFS
        // Queue<TreeNode> qC = new LinkedList<>();
        // Queue<TreeNode> qP = new LinkedList<>();

        // qC.add(root);
        // qP.add(null);

        // while(!qC.isEmpty())
        // {
        //     int size = qC.size();
        //     TreeNode xParent = null;
        //     TreeNode yParent = null;
        //     boolean xFound = false;
        //     boolean yFound = false;

        //     for(int i=0;i<size;i++)
        //     {
        //         TreeNode curr = qC.poll();
        //         TreeNode parent =qP.poll();

        //         if(curr.val==x)
        //         {
        //             xFound=true;
        //             xParent =parent;
        //         }

        //         if(curr.val==y)
        //         {
        //             yFound=true;
        //             yParent =parent;
        //         }

        //         if(curr.left!=null)
        //         {
        //             qC.add(curr.left);
        //             qP.add(curr);
        //         }
                

        //         if(curr.right!=null)
        //         {
        //             qC.add(curr.right);
        //             qP.add(curr);
        //         }
                

        //     }

        //     if(xFound && yFound)
        //     return xParent!=yParent;

        //     if(xFound || yFound)
        //     return false;

        // }
        // return false;
    }
}