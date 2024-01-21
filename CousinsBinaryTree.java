// BFS tc: o(n) sc: o(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xfound = false;
            boolean yfound = false;
            for(int i=0; i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    xfound = true;
                } 
                if(curr.val == y){
                    yfound = true;
                } 
                if( curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(xfound && yfound){
                return true;
            }
            if(xfound || yfound) return false;
        }
        return false;
    }
}
// DFS tc: o(n) sc: o(n)
class Solution1 {
    TreeNode parentX;
    TreeNode parentY;
    int depthX;
    int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,null, x,  y);
        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
        if(root == null) return;
        if(root.val == x){
            depthX = depth;
            parentX = parent;
        }
        if(root.val == y){
            depthY = depth;
            parentY = parent;
        }
        dfs(root.left, depth+1, root, x,y);
        dfs(root.right, depth+1, root, x,y);
    }
}
