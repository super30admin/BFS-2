/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean xval=false,yval=false;
        while(!q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode temp=q.poll();
                if(temp.val==x) xval=true;
                if(temp.val==y) yval=true;
                if(temp.left!=null && temp.right!=null)
                {
                    if((temp.left.val==x && temp.right.val==y) || (temp.left.val==y && temp.right.val==x))
                        return false;
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            if(xval==true && yval==true) return true;
            if(xval==true || yval==true) return false;
        }
        return false;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)