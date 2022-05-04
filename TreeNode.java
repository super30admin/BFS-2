public class TreeNode{

    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(){}

    public TreeNode(int val)
    {
        this.val=val;
    }

    public TreeNode(TreeNode left,TreeNode right, int val)
    {
        this.left=left;
        this.right=right;
        this.val=val;
    }
}