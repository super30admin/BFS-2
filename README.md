# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

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
    //TC O(n) SC O(n)
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                q.add(curr.right);
                }
            }
        }
        return result;
    }
    
    
    
}

## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

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
    //TC O(n) SC O(h)
    int x_lvl, y_lvl;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        dfs(root, 0, null, x, y);
        
        return x_lvl == y_lvl && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int lvl, TreeNode Parent, int x, int y){
        //base case
        if(root == null) return;
        //logic
        if(root.val == x){
            x_lvl = lvl;
            x_parent = Parent;
        }
            if(root.val == y){
            y_lvl = lvl;
            y_parent = Parent;
        }
        dfs(root.left, lvl +1 , root, x, y);
        dfs(root.right, lvl +1 , root, x, y);
        
    }
}


