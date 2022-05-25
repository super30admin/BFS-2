//Time: O(N)
//Space: O(Width of the tree)

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

// BFS solution
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int qCurrSize = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0;i<qCurrSize;i++) {
                TreeNode curr = queue.poll();
                // edge case, when x and y are not yet found at the parent level,
                // we check their children, if the x and y have same parent,
                // if so, we break the loop and return false then and there itself
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) return false;
                }
                // when either x or y is found, we mark the boolean variables to true
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                // we keep adding left right babies to the queue for processing next levels
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            // if both x and y are found at the same level, we return true
            if(xFound && yFound) return true;
            // if one of them found first, we return false,
            // if both are not found yet, we will traverse next next levels
            if(xFound || yFound) return false;
        }
        return false;
    }
}

//DFS - Time: O(N) | Space: O(Height of the tree)

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
class Solution {
    boolean areCousins;
    boolean firstElementFound = false;
    TreeNode firstParent = null;
    int depth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        areCousins = true;
        areTheyCousins(root, x, y, null, 0);
        return areCousins;
    }
    private void areTheyCousins(TreeNode root, int x, int y, TreeNode parent, int currSum) {
        if(root == null) return;
        areTheyCousins(root.left, x, y, root, currSum+1);
        areTheyCousins(root.right, x, y, root, currSum+1);
        if(root.val == x || root.val == y) {
            // if either x or y is found first,
            // we update the firstElementFound to true
            if(!firstElementFound) {
                firstElementFound = true;
                firstParent = parent;
                depth = currSum;
            } else {
                // when we find the other value(x or y),
                // if they are at different level or parent not there(incase of root node), or parent are same,
                // we set areCousins to false
                if(firstParent == null || parent == null || firstParent.val == parent.val || depth != currSum) {
                    areCousins = false;
                }
            }
        }

    }
}