// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
      if(root==null)
      return false;
        int l = height(root,x,y);
        int r = height(root,y,x);

        if(l!=r)
        check = false;

      return check;  
    }
    
    boolean check = true;

    int height(TreeNode root , int x ,int y){
        if(root==null)
        return 0;

        if(root.left!=null && root.right!=null){
            if(root.left.val==x && root.right.val==y)
            check=false;

            if(root.left.val==y && root.right.val==x)
            check=false;
        }
        if(root.val==x)
        return 1;

        if(height(root.left,x,y)>0)
        return height(root.left,x,y)+1;

        else if(height(root.right,x,y)>0)
        return height(root.right,x,y)+1;

        else
        return 0;
    }
}