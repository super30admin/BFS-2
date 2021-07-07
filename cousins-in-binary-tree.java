// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DFS SOLUTION
class Solution {
    int x_depth; int y_depth;
    TreeNode x_parent; TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        dfs(root, null, 0, x, y);
        return x_depth==y_depth && x_parent!=y_parent;
    }
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root==null){
            return;
        }
        if(root.val==x){
            x_depth=depth;
            x_parent=parent;
        }
        if(root.val==y){
            y_depth=depth;
            y_parent=parent;
        }
        dfs(root.left, root, depth+1, x, y);
        dfs(root.right, root, depth+1, x, y);
    }
}

//BFS solution
class Solution {   
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue <TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false; boolean y_found=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.val==x){
                    x_found=true;
                }
                if(curr.val==y){
                    y_found=true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }
                    if(curr.left.val==y && curr.right.val==x){
                        return false;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(x_found && y_found){
                return true;
            }
            if(x_found || y_found){
                return false;
            }
        }
        return false;
    }
}