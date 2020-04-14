// Time Complexity : O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
public class CousinsInBinaryTree {
    HashMap<Integer, Integer> heightMap;
    HashMap<Integer, Integer> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }

        heightMap = new HashMap<>();
        parent = new HashMap<>();

        buildMap(root, 0);

        if(parent.get(x) != parent.get(y) && heightMap.get(x) == heightMap.get(y)){
            return true;
        } else {
            return false;
        }
    }

    private void buildMap(TreeNode node, int height){
        if(node == null){
            return;
        }
        heightMap.put(node.val, height);
        if(node.left!=null) {
            parent.put(node.left.val, node.val);
            buildMap(node.left, height + 1);
        }
        if(node.right!=null){
            parent.put(node.right.val, node.val);
            buildMap(node.right, height + 1);
        }
    }
}
