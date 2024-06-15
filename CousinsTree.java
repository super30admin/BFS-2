//Time Complexity: O(n)
//Space Complexity: O(h)
public class CousinsTree {
    int x_depth=-1;
    int y_depth=-1;
    TreeNode x_parent=null;
    TreeNode y_parent=null;

    public boolean isCousins(TreeNode root, int x, int y)
    {
        calDepthAndParent(root,x,y,0,null);
        return x_depth == y_depth && x_parent!=y_parent;
    }

    public void calDepthAndParent(TreeNode root,int x,int y,int depth, TreeNode parent){

        if(root==null)

            return;

        if(root.val==x)

        {  x_parent=parent;

            x_depth=depth;}

        if(root.val==y)

        {y_parent=parent;

            y_depth=depth;}

        calDepthAndParent(root.left,x,y,depth+1,root);

        calDepthAndParent(root.right,x,y,depth+1,root);
    }
    public static void main(String[] args) {
        CousinsTree tree = new CousinsTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        System.out.println(tree.isCousins(root,4,6));
    }
}
