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

//DFS Approach

class Solution {

    //Time Complexity: 0(n)
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while solving: No

    //In short explain your approach: I am maintaining a level as I traverse through the tree to check the level at which the
    //node is present. If the node is found, then I store both x and y node's level and it's parent. If level matches and
    //parent don't then I return true or false.

    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        dfs(root, 0, null, x, y);
        return x_level == y_level && x_parent != y_parent;
    }
    public void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root == null){
            return;
        }
        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}

//BFS approach
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(current.val == x){
                    x_found = true;
                }
                if(current.val == y){
                    y_found = true;
                }
                if(current.left != null && current.right != null){
                    if(current.left.val == x && current.right.val == y){
                        return false;
                    }
                    if(current.left.val == y && current.right.val == x){
                        return false;
                    }
                }
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
            if( x_found && y_found){
                return true;
            }
            if( x_found || y_found){
                return false;
            }
        }
        return false;
    }
}