//Time Complexity: O(n) 
//Space Complexity: O(h)
// DFS
public class CousinsBt {
    TreeNode x_parent, y_parent;
    int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_level == y_level;
        
    }
    private void dfs(TreeNode root, int x, int y, int lvl, TreeNode parent){
        if(root == null)
            return;
        if(root.val == x){
            x_parent = parent;
            x_level = lvl;
        }
        if(root.val == y){
            y_parent = parent;
            y_level = lvl;
        }
        dfs(root.left, x, y, lvl + 1, root);
        dfs(root.right, x, y, lvl + 1, root);
        
    }
}
//Time Complexity: O(n) 
//Space Complexity: O(h)
// BFS
public class CousinsBt {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean x_found = false, y_found = false;
            for(int i = 0 ; i < size ; i ++)
            {
                TreeNode curr = q.poll();
                if(curr.val == x)
                {
                    x_found = true;
                }
                else if(curr.val == y)
                {
                    y_found = true;
                }
                
                if(x_found == true && y_found == true)
                    return true;
                if(x_found || y_found)
                    continue;
                // same parent
                if(curr.left != null && curr.right != null && curr.left.val == x && curr.right.val == y)                                                return false;
                // same parent
                if(curr.left != null && curr.right != null && curr.left.val == y && curr.right.val == x)
                    return false;
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            if(x_found == true && y_found == true)
                return true;
            if(x_found || y_found)
                return false;
        }
        return false;
    }
}
