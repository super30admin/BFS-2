// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val==x)
                    x_found = true;
                if(curr.val==y)
                    y_found = true;
                if(curr.left!=null && curr.right!=null){
                 if((curr.left.val==x&&curr.right.val==y)||(curr.left.val==y&&curr.right.val==x)){
                     return false;
                 }
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            if(x_found==true && y_found==true ) return true;
            if(x_found==true || y_found ==true) return false;
        }
        return false;
    }
}

class Solution {
    int x_lvl, y_lvl;
    TreeNode x_parent, y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        dfs(root, 0, null, x, y);
        return x_lvl==y_lvl&&x_parent!=y_parent;
    }
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        if(root==null)
            return;
        if(root.val==x){
            x_parent = parent;
            x_lvl = level;
        }
        if(root.val==y){
            y_parent = parent;
            y_lvl = level;
        }
        if(x_parent==null||y_parent==null){
            dfs(root.left,level+1,root,x,y);
            dfs(root.right,level+1,root,x,y);
        }
    }
}