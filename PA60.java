//Leetcode : 993. Cousins in Binary Tree

//BFS solution
//Time Complexity: O(n) , n is no of nodes in the tree
//Space Complexity: O(n) , n is equal to the maxmimum width of the tree , n/2 in complete binary tree
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x  || root.val==y){
            return false;
        }   
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int xd=0;
        int yd=0;
        int d=0;
        while(!q.isEmpty()){
            d++;
            int s= q.size();
            
            for(int i=0;i<s;i++){
                TreeNode n= q.poll();
                if(n.left!=null && n.right!=null ){
                    if((n.left.val==x || n.right.val==x) && (n.left.val==y || n.right.val==y)){
                        return false;
                    }
                }
                if(n.left!=null){
                    if(n.left.val==x) xd= d;
                    if(n.left.val==y) yd=d;
                    q.add(n.left);
                    
                } 
                if(n.right!=null){
                    if(n.right.val==x) xd= d;
                    if(n.right.val==y) yd=d;
                    q.add(n.right);
                    
                } 
            }
            if(xd!=0 && yd!=0){
                break;
            }
            
        }
        return xd==yd;
        
    }
}


==============================================================================
DFS solution:

//Time Complexity: O(n) , n is no of nodes in the tree
//Space Complexity: O(n) , n is equal to the height of the tree 
class Solution {
    int xd;
    int yd;
    TreeNode xp;
    TreeNode yp;
    
    public boolean isCousins(TreeNode root, int x, int y) {
    
        if(root==null || root.val==x  || root.val==y){
            return false;
        }   
        xd=0;
        yd=0;
        dfs(null,root, x, y, 0);
        if(xp==yp){
            return false;
        }
        return xd==yd;
        
    }
    private void dfs(TreeNode p,TreeNode root, int x, int y, int d){
        if(root==null){
            return;
        }
        if(root.val==x){
            xd=d;
            xp=p;
        }
        if(root.val==y){
            yd=d;
            yp=p;
        }
        dfs(root,root.left,x,y,d+1);
        dfs(root,root.right,x,y,d+1);
        return;
    }
}