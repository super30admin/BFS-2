import java.util.*;

public class binaryTreeRightSideView 
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution 
    {
        public void func(TreeNode root,ArrayList<Integer> al,int h)
        {
            if(root == null)
            {
                return;
            }
            
            if(al.size()==h)
                {
                    al.add(root.val);
                }
            func(root.right,al,h+1);
            func(root.left,al,h+1);
            
        }
        public List<Integer> rightSideView(TreeNode root) 
        {
            ArrayList<Integer> al= new ArrayList<>();
            func(root,al,0);
            return al;
        }
    }
}
