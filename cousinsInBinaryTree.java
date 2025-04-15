public class cousinsInBinaryTree 
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
        public void parent(TreeNode root,int x,int h,int[] ar1)
        {
            if(root.left!=null)
            {
                if(root.left.val == x)
                {
                    ar1[0] = root.val;
                    ar1[1]  = h+1;
                    return ;
                }
                parent(root.left,x,h+1,ar1);
            }
            if(root.right!=null)
            {
                if(root.right.val == x)
                {
                    ar1[0] = root.val;
                    ar1[1]  = h+1;
                    return ;
                }
                parent(root.right,x,h+1,ar1);
            }
        }
        public boolean isCousins(TreeNode root, int x, int y) 
        {
    
            int[] ar1  = new int[2];
            parent(root,x,0,ar1);
            int[] ar2  = new int[2];
            parent(root,y,0,ar2);
            if(ar1[1] != ar2[1])
            {
                return false;
            }
            if(ar1[1] == ar2[1] && ar1[0] == ar2[0])
            {
                return false;
            }
            return true;
        }
    }
}
