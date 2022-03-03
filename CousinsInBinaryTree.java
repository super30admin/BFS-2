/*

Time Complexity: O(N), N is the number of nodes in the tree
Space Complexity: O(H), H is the height of the tree
Run on the leetcode: yes
Any difficulties: no

Approach:
Attempted after discussed in the class

 */
public class CousinsInBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode parentX, parentY;
    private int levelX, levelY;
    private int x, y;
    public boolean isCousins(TreeNode root, int x, int y){
        parentX = null;
        parentY = null;
        this.x = x;
        this.y = y;

        isCousinsNodes(root, null, 0);

        return levelX==levelY && parentX!=parentY;
    }
    public void isCousinsNodes(TreeNode root, TreeNode parent, int level){
        if(root == null){
            return;
        }

        if(root.val == x){
            parentX = parent;
            levelX = level;
        }
        if(root.val == y){
            parentY = parent;
            levelY = level;
        }

        isCousinsNodes(root.left, root, level+1);
        isCousinsNodes(root.right, root, level+1);

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        CousinsInBinaryTree obj = new CousinsInBinaryTree();

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(obj.isCousins(root, 4,3));
    }
}
