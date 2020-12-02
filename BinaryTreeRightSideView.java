// time complexity- O(n) where n is the number of tree nodes

// space complexity- O(h) is the height of the tree
import java.util.*;
public class BinaryTreeRightSideView {
    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
            left = right = null;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        buildList(root, li, 0);
        return li;
    }
    private void  buildList(TreeNode node, List<Integer> li, int level) {
        if(node == null) return;
        if(li.size() == level) li.add(node.val);

        buildList(node.right, li, level + 1);
        buildList(node.left, li, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
        System.out.println(tree.rightSideView(root));
    }
}
