//Time Complexity :O(n)
//Space Complexity:O(h)
//Amazon interview
//second method Using DFS: The DFS starts from root, if they are in same level from diferent parents so then they are cousins .Consider X-depth and y_depth as well as x_parent and y_parent if this x=y depth and x!=y parent then it return true because they are cousins.
//In java int =automatically initialize to zero
//Int java TreeNode =automatically initialize to null, it start from root then its previous node it should be null 
//In java boolean =automatically initialize to false
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
     List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        result = new ArrayList<>();
        //Using DFS
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()) {
            result.add(root.val);
        }else{
            result.set(level,root.val);//A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction. The Set interface contains only methods inherited from Collection and adds the restriction that duplicate elements are prohibited
        }
        dfs(root.left,level+1);//second method first checks left and then right of the tree
        dfs(root.right,level+1);
        
    }
}