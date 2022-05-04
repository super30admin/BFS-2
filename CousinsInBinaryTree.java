import java.util.*;
public class CousinsInBinaryTree {
    

    public static int x_level,y_level;
    public static TreeNode x_parent,y_parent;
    public static boolean isCousins(TreeNode root, int x,int y)
    {
        if(root == null)
        {
            return false;

        }

        dfs(root,0,null,x,y);

        return x_level == y_level && x_parent==y_parent;

    }

    public static void dfs(TreeNode root,int level, TreeNode parent,int x,int y)
    {
        if(root == null)
        {
            return;
        }

        if(root.val==x)
        {
            x_level = level;
            x_parent = parent;
        }

        if(root.val==y)
        {
            y_level = level;
            y_parent = parent;
        }

        dfs(root.left,level+1,root,x,y);
        dfs(root.right,level+1,root,x,y);
    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode twoRight = new TreeNode(5);
        TreeNode threeRight = new TreeNode(4);

        root.left=rootLeft;
        root.right=rootRight;

        rootLeft.right=twoRight;
        rootRight.right=threeRight;

        boolean ans = isCousins(root,2,3);
        System.out.println(ans);
        
    }
}
