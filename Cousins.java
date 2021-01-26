// Time Complexity : O(n)
// Space Complexity : O(h) based on recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Cousins {
    TreeNode Parent1;
    TreeNode Parent2;
    int x_level;
    int y_level;
    boolean flag;
    public boolean isCousins(TreeNode root, int x, int y) {
        x_level = -1;
        y_level = -1;
        if(root == null) return false;
        flag = true;
        dfs(root, 0, x, y, null);
        //switch triggered if not cousins
        return flag;
    }

    public void dfs(TreeNode root, int level, int x, int y, TreeNode parent){
        if(root == null) return;
        //if found x, store its parent
        if(root.val == x){
            Parent1 = parent;
            x_level = level;
        }
        //found y, store its parent
        else if(root.val == y){
            Parent2 = parent;
            y_level = level;
        }

        //if found and not on same level/if same parent
        if(x_level != -1 && y_level != -1){
            if(x_level != y_level){
                flag = false;
            }
            else{
                if(Parent1.val == Parent2.val){
                    flag = false;
                }
            }
        }
        //move to next level
        dfs(root.right, level + 1, x, y, root);
        dfs(root.left, level + 1, x, y, root);
    }
}