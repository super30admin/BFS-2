
// Both should in be same depth and different parent
//DFS: We travers through all the elements if we find the x/y value save the value.
// In order to check the parent, pass the parent value as well and save the parent.
//At the end of the traversal, compare the base condition that same deapth and different parent.


//TC: O(N) where N is the height of the tree, since we travers through all the elements.
//SC: O(N) - Due to the recursive calls. 

public class CousinsInBinaryTree {

    int xDepth = -1;
    int yDeapth = -1;
    int xParent = -1;
    int yParent = -1;

    public boolean isCousinsBFSRecursive(TreeNode node, int x, int y) {
        helper(node, 0, -1, x, y);

        if (xDepth != yDeapth || xParent == yParent) {
            return false;
        }
        return true;
    }

    public void helper(TreeNode node, int depth, int parent, int x, int y) {
        if (node == null)
            return;
        if (x == node.val) {
            xDepth = depth;
            xParent = parent;
        }

        if (y == node.val) {
            yDeapth = depth;
            xParent = parent;
        }
        helper(node.left, depth + 1, node.val, x, y);
        helper(node.right, depth + 1, node.val, x, y);

    }

    public static void main(String[] args) {
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        TreeNode root = new TreeNode().getSampleTwo(); // 4,3
        // TreeNode root = new TreeNode().getSampleThree(); // 5,4
        // final boolean isCousins = binaryTreeRightSideView_993.isCousins(root, 4, 3);
        final boolean isCousins = cousinsInBinaryTree.isCousinsBFSRecursive(root, 4, 3);
        System.out.println("The given nodes are cousins:" + isCousins);
    }
}
