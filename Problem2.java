/*
Check if given tree nodes are cousins
approach: do bfs and check if both nodes found on same level
time: O(n)
space: O(n)
 */
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
public class Problem2 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean x_found=false, y_found=false;
            for(int i=0;i<size;i++) {
                TreeNode popped = q.poll();
                if(popped.val==x) {
                    x_found = true;
                }
                if(popped.val==y) {
                    y_found = true;
                }
                if(popped.left!=null && popped.right!=null) {
                    if(popped.left.val==x && popped.right.val==y) return false;
                    if(popped.right.val==x && popped.left.val==y) return false;
                }
                if(popped.left!=null ) q.add(popped.left);
                if(popped.right!=null ) q.add(popped.right);
            }
            if(x_found && y_found) return true;

        }
        return false;
    }
    // public boolean isCousinsDFS(TreeNode root, int x, int y) {
    //     dfs(root, root.val, x, y, 0);

    //     return flag;
    // }

    // private void dfs(TreeNode root, int parent, int x, int y, int dep) {
    //     if(root==null) return;
    //     if(!flag) {
    //     if(root.val ==x) {
    //         x_parent = parent;
    //         x_found = true;
    //         x_depth = dep;
    //     }

    //     if(root.val ==y) {
    //         y_parent = parent;
    //         y_found = true;
    //         y_depth = dep;
    //     }

    //     if(x_found && y_found) {
    //         if(x_parent!=y_parent && x_depth==y_depth) {
    //             flag = true;
    //         }
    //     }
    //     if(root.left!=null) dfs(root.left, root.val, x, y, dep+1);
    //     if(root.right!=null) dfs(root.right, root.val, x, y, dep+1);
    //     }
    // }
}
