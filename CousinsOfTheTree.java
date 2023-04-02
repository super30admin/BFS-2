//Leetcode - 993
//TC - O(N)
//SC - O(H)
public class CousinsOfTheTree {
    class TreeNode {
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
    int depth_x;
    int depth_y;
    TreeNode parentX;
    TreeNode parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return depth_x == depth_y && (parentX != parentY);
    }
    //DFS approach
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        //base
        if(root == null) return;
        //logic
        if(root.val == x) {
            depth_x = depth;
            parentX = parent;
        }
        if(root.val == y) {
            depth_y = depth;
            parentY = parent;
        }
        if(parentX == null || parentY == null)
            dfs(root.left, root, depth+1, x, y);
        if(parentX == null || parentY == null)
            dfs(root.right, root, depth+1, x, y);
    }

    //BFS approach
    /*
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();
        q.add(root);
        parentQ.add(null);
        TreeNode px = null;
        TreeNode py = null;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i =0; i<size; i++) {
                TreeNode curr = q.poll();
                TreeNode currP = parentQ.poll();
                if(curr.val == x){
                    x_found = true;
                    px = currP;
                }
                if(curr.val == y){
                    y_found = true;
                    py = currP;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    parentQ.add(curr);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }
            if(x_found && y_found) return px != py;
            if(x_found || y_found) return false;
        }
        return false;
    }
     */
}
