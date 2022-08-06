//Time Complexity = O(N), where N is the number of nodes
//Space Complexity = O(H), where H is the height of the tree
//Did it run successfully on Leetcode: Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//if the nodes are of same depth and not have same parents, they are considered as cousins.
class BTCousinsDFS {
    int xDepth, yDepth;
    TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        //base case
        if(root == null) return false;

        dfs(root, 0, null, x, y);
        return (xDepth == yDepth) && (xParent != yParent);
    }

    //preorder is used here, any order should work for this method.
    void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
        if(root == null) return;

        if(root.val == x) {
            xDepth = level;
            xParent = parent;
        }

        if(root.val == y) {
            yDepth = level;
            yParent = parent;
        }

        if(xParent == null || yParent == null) {
            dfs(root.left, level+1, root, x, y);
            dfs(root.right, level+1, root, x, y);
        }
    }

}