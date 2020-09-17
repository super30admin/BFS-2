//Time Complexity: O(n) where n is the maximum diameter in the tree
//Space Complexity: O(1)

import java.util.*;

public class CousinsInBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<TreeNode>> res = new ArrayList<>();
        //res is the result that we need and 0 is the levels
        helper(root,res,0,x,y);
        if(levelX == levelY && parentX != parentY)
            return true;
        return false;
    }
    TreeNode parentX;
    TreeNode parentY;
    int levelX=-1;
    int levelY=-1;
    public void helper(TreeNode root, List<List<TreeNode>> result, int level, int x, int y){
        if(root==null) 
            return;
        //level == size of the result then return empty Arraylist
        if(result.size()==level)
           result.add(new ArrayList<TreeNode>());
        //if arraylist is present then add value to it
        result.get(level).add(root);

        //checking if roots left and right matches the target if yes update the global parent and the level
        if((root.left != null && root.left.val == x) || (root.right!=null && root.right.val == x)){
            parentX = root;
            levelX = level;
        }
        if((root.left != null && root.left.val == y) || (root.right!=null && root.right.val == y)){
            parentY = root;
            levelY = level;
        }
        //traverse left and increment the level
        helper(root.left,result,level+1,x,y);
        //traverse right and increment the level
        helper(root.right,result,level+1,x,y);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}