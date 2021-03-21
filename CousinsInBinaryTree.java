
import java.util.*;
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

    public boolean isCousinsDFSRecursive(TreeNode node, int x, int y) {
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

    public boolean isCousinsBFS(TreeNode node, int x, int y) {
        if (node == null)
            return false;

        // BFS - using a queue traverse all the element level by level.
        // Depth should be equal and parent should not be same.

        Queue<Pair<Integer, TreeNode>> queue = new LinkedList();
        Pair<Integer, TreeNode> pair = new Pair(-1, node);
        queue.offer(pair);
        int depth = 0;
        while (!queue.isEmpty()) {

            int size = queue.size(); // 2
            int xDepth = -1;
            int yDepth = -1;
            int xParent = -1;
            int yParent = -1;

            for (int i = 0; i < size; i++) {
                Pair<Integer, TreeNode> currentPair = queue.poll();
                TreeNode currentNode = currentPair.getValue(); //
                int parent = currentPair.getKey(); // 1
                if (x == currentNode.val) {
                    xDepth = depth;
                    xParent = parent;
                }
                if (y == currentNode.val) {
                    yDepth = depth;
                    yParent = parent;
                }

                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.val, currentNode.left));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.val, currentNode.right));
                }
            }
            depth++;

            if (xDepth != -1 && yDepth != -1 && xParent != -1 && yParent != -1 && xDepth == yDepth
                    && xParent != yParent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        //TreeNode root = new TreeNode().getSampleTwo(); // 4,3
        // TreeNode root = new TreeNode().getSampleThree(); // 5,4
        // final boolean isCousins = binaryTreeRightSideView_993.isCousins(root, 4, 3);
        // final boolean isCousins = cousinsInBinaryTree.isCousinsDFSRecursive(root, 4,
        // 3);

        TreeNode root = new TreeNode().getSampleSix(); // 4,5
        final boolean isCousins = cousinsInBinaryTree.isCousinsBFS(root, 4, 5);
        System.out.println("The given nodes are cousins:" + isCousins);
    }
}
