//Time Complexity :O(n)
//Space Complexity:O(n)
//Amazon interview
//Using BFS://Time Complexity :O(n)
//Space Complexity:O(n)
//Amazon interview
//Using BFS: The BFS starts from root, Consider x and y if found then return false elese it should return true.It compares the root of tree with sub trees example consider the root as parent of same child it should compare the left and right child of the tree.Go into the loop again and check, if found it should return x and y else to remove the current element from queue treenode and loop continues and checks againg and again but here it will contiue it returns also then starts continue of the loop it wont go back if not found.
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
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
    if(root == null || x== y)return false;
        dfs(root,0,null,x,y);//0-parent
        return x_depth == y_depth && x_parent != y_parent;
    }
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
    //base 
        if(root ==  null) return;
    //logic 
    //Inorder traversal
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
    }
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
    }
        if(x_parent == null || y_parent == null){
            dfs(root.left,level+1,root,x,y); 
        }
        if(x_parent == null || y_parent == null){
            dfs(root.right,level+1,root,x,y);  
        }
    
    }
}
