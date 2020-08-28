// Time Complexity : O(N), N is number of nodes in the tree
// Space Complexity : O(H), H is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// For brute force approach, w can keep map of map and level of each node of the tree and get the parent and level of X and Y
// nodes from the map. if the parent is same or level value of x and y is different that means x and y are not cousins else
// they are. using optimal way, we can keep 4 pointers for  X and Y, 2 for parent values and 2 for level values. We can perform
// and store values of paren and level if the node value matches x or y. Once dfs is complete, we compare the 4 pointers as before
// return true or false.

import java.util.HashMap;
import java.util.Map;

public class CousinsInBT {
    Map<Integer, Integer[]> parentLevelMap;
    int xlevel, ylevel, xparent, yparent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        //bruteforce(root, x, y);
        dfs(root, x, y, 0, null);
        return xlevel == ylevel && xparent != yparent;
    }

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        if (root == null) return;

        if (root.val == x) {
            xlevel = level;
            xparent = parent.val;
        }

        if (root.val == y) {
            ylevel = level;
            yparent = parent.val;
        }

        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }


    /*Bruteforce approach to keep a map of parent and level */
    private boolean bruteforce(TreeNode root, int x, int y) {
        parentLevelMap = new HashMap<>();

        getLevelAndParent(new TreeNode(-1), root, 0);

        int xLevel = parentLevelMap.get(x)[1];
        int yLevel = parentLevelMap.get(y)[1];

        Integer xParent = parentLevelMap.get(x)[0];
        Integer yParent = parentLevelMap.get(y)[0];

        return xLevel == yLevel && yParent != xParent;
    }

    private void getLevelAndParent(TreeNode parent, TreeNode current, int level) {
        if (current == null) return;

        Integer[] parentLevelPair = {parent.val, level};
        parentLevelMap.put(current.val, parentLevelPair);

        getLevelAndParent(current, current.left, level + 1);
        getLevelAndParent(current, current.right, level + 1);
    }
}
