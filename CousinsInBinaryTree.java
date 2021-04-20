/**Leetcode Question 993 - Cosuins in Binary Tree */
/**Algo - BFS
 * Push the root in a queue.
 * Check if x, y are found. 
 * Check if the parent of x and y are same, return false
 * Add the left and right child of the root in the queue.
 * Check if both x, y are found and have different parents, return true.
 */
/**TC- O(N)
 * SC- (N/2+1) = O(N)
 */
public class CousinsInBinaryTree {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if(root == null){
                return false;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                boolean x_found = false, y_found = false;
                for(int i =0; i< size; i++){
                    TreeNode curr = q.poll();
                    if(curr.val == x){
                        x_found = true;
                    }
                    if(curr.val == y){
                        y_found = true;
                    }
                    if(curr.left != null && curr.right != null){
                        if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                            return false;
                        }
                    }
                    if(curr.left!= null){
                        q.add(curr.left);
                    }
                    if(curr.right!= null){
                        q.add(curr.right);
                    }
                } 
                if(x_found == true && y_found == true){
                    return true;
                }
                if(x_found == true || y_found == true){
                    return false;
                }
            }
            return true;
        }
    }
}
/**Algo - DFS */
class Solution {
    boolean x_found, y_found; 
    TreeNode x_parent, y_parent; 
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        dfs(root, x,y, null, 0);
        return(x_found && y_found && x_parent!=y_parent && x_lvl == y_lvl);
    }
    private void dfs(TreeNode root, int x, int y, TreeNode parent, int lvl){
        //base
        if(root == null){
            return;
        }
        if(x_found == true && y_found==true){
            return;
        }
        //logic
        if(root.val == x){
            x_found = true;
            x_lvl = lvl;
            x_parent = parent;
        }
        if(root.val == y){
            y_found = true;
            y_lvl = lvl;
            y_parent = parent;
        }
        dfs(root.left,x,y, root, lvl+1);
        dfs(root.right,x,y, root, lvl+1);
    }
}