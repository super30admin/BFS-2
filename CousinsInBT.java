
public class CousinsInBTBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                
                // check if they have the same parent
                if(curr.left!=null&&curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            // check after completing each level of the tree
            if(x_found&&y_found) return true;
            if(x_found||y_found) return false;
        }
        return true;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)


public class CousinsInBTDFS {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root,x,y,0,null);
        return x_parent!=y_parent && x_depth==y_depth;
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        //base
        if(root==null) return;
        
        if(root.val==x){
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val==y){
            y_parent = parent;
            y_depth = depth;
        }
        
        // logic
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)