// Time Complexity :O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use a class variable x_level, y_level and boolean same_parent
 * We will traverse tree using DFS approach and we will check if we current element is x or y and accordingly we update x_level and y_level
 * Also, for each element we check if its children have values of x and y. If yes, we make same_parent as true.
 * at the end, if x_level != y_level or same_parent is true, we return false. Else we return true.
 * Also, during DFS, if same_parent has been set to true, we dont go ahead traversing and return. ( Little optimization)
*/

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
    int x_level;
    int y_level;
    boolean same_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        x_level = -1;
        y_level = -1;
        
        dfs(root, x, y, 0);
        if(x_level != y_level || same_parent == true)return false;
        
        return true;
    }
    
    private void dfs(TreeNode root,int x, int y, int level){
        //base case
        if(root == null){
            return;
        }
        if(same_parent)return;
        
        //logic
        if(root.val == x){
            x_level = level;
        }
        if(root.val == y){
            y_level = level;
        }
        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y){
                same_parent = true;
            }
            if(root.left.val == y && root.right.val == x){
                same_parent = true;
            }
        }
        dfs(root.left, x, y, level + 1);
        dfs(root.right, x, y, level + 1);
    }
    
}