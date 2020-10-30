//BFS
//TC: O(n)
//SC: O(width) = O(n/2)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false; boolean yFound = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if((curr.left != null && (curr.left.val == x || curr.left.val == y)) && (curr.right != null && (curr.right.val == x || curr.right.val == y))){
                    return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(curr.val == x) xFound = true;
                else if(curr.val == y) yFound = true;
                if(xFound && yFound) return true;
            }
        }
        return false;
    }
}

//DFS
//TC: O(n)
//SC: O(h)
class Solution {
    TreeNode xParent; TreeNode yParent;
    int xDepth; int yDepth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, 0, null, x, y);
        return xParent != yParent && xDepth == yDepth;
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            xParent = parent;
            xDepth = level;
        }
        
        else if(root.val == y){
            yParent = parent;
            yDepth = level;
        }
        
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}
