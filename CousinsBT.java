/*
Author: Akhilesh Borgaonkar
Problem: Determine if x & y are cousins (i.e. xDepth=yDepth and xParent!=yParent)

*/

public class CousinsBT {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){ value = val; }
    }

    private static int xdep = -1;
    private static int ydep = -1;
    private static TreeNode xPar = null;
    private static TreeNode yPar = null;

    private static boolean isCousin(TreeNode treeNode, int x, int y){
        findParent(treeNode, 0 , x, y, null);

        return xdep==ydep && xPar!=yPar;
    }

    private static void findParent(TreeNode root, int depth, int x, int y, TreeNode parent){
        if(root == null)
            return;
        if(root.value==x) {
            xdep = depth;
            xPar = parent;
        }
        if(root.value == y){
            ydep = depth;
            yPar = parent;
        }

        findParent(root.left, depth+1, x, y, root);
        findParent(root.right, depth+1, x, y, root);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);

        int x = 2;
        int y = 3;

        if(isCousin(treeNode, x, y))
            System.out.println("X & Y are cousins");
        else
            System.out.println("X & Y are not cousins");
    }
}
