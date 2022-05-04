import java.util.*;
public class BinaryTreeRightSideView {
    

   public static List<Integer> result;

    public static List<Integer> rightSideView(TreeNode root)
    {
        result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }

        helper(root,0);
        return result;
    }


    public static void helper(TreeNode root, int level)
    {
        if(root == null)
        {
            return;
        }

        if(level==result.size())
        {
            result.add(root.val);
        }

        helper(root.right,level+1);
        helper(root.left,level+1);
    }


    public static List<Integer> helper2(TreeNode root)
    {
        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            

            for(int i =0;i<size;i++)
            {
                TreeNode curr = q.poll();
                if(i==size - 1)
                {
                    result.add(curr.val);
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }

                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }

        return result;
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

        List<Integer> answer = rightSideView(root);

        for(int i: answer)
        {
            System.out.print(i+" ");
        }
    }
}
