//TC: O(n)
//SC: O(n)
//works in leetcode
public class BinaryTreeCousins {
    //if x and y have different parent
    //same order or depth
    static int xOrder=0,yOrder=0;
    static TreeNode xParent=null, yParent=null;

    public static boolean isCousins(TreeNode root, int x, int y) {

        isCousinsRec(root,  x,  y, 0, null);

        return (xParent!=yParent) && xOrder==yOrder;
    }

    private static void isCousinsRec(TreeNode node, int x, int y, int order, TreeNode parent){
        if(node==null)
            return;

        if(node.val==x){
            xOrder = order;
            xParent = parent;
        }
        if(node.val==y){
            yOrder = order;
            yParent = parent;
        }

        order++;
        isCousinsRec(node.left, x,  y,  order,  node);
        isCousinsRec(node.right, x, y,  order,  node);

    }

    public static void main(String [] args){
        TreeNode node1 = new TreeNode(4, null,null);

        TreeNode node3 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(3,null,node1);
        TreeNode node2 = new TreeNode(2,null,node3);
        TreeNode head = new TreeNode(1,node2,node4);

        System.out.println(isCousins(head, 5,  4));
        System.out.println(isCousins(head, 5,  2));

    }
}
