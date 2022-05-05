//bfs solution
// TC & SC --> o(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.val == x) {
                    x_found = true;
                }
                if(cur.val == y) {
                    y_found = true;
                }
                if(cur.left != null && cur.right != null) {
                    if(cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                    if(cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                }
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            if(x_found && y_found) {
                return true;
            }
            if(x_found || y_found) {
                return false;
            }
        }
        return false;
    }
}