//Problem : 61 - Cousins in Binary Tree
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : n -> number of nodes. However as we will be storing max of all nodes at last level. Therefore space comexity will be O(n/2)+something, but constant won't matter thats why O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1) BFS : Without using 4 variables, and if x and y are children of same parents then result can be given without going to another level;
//2) DFS: Using 4 variables


class Solution61Optimized{
    
    class TreeNode{
         int val;
         TreeNode left,right;
         TreeNode(int val){
             this.val = val;
         }
    }

    //dfs
    private TreeNode parentX,parentY;
    private int levelX, levelY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        //TC:O(N)|  SC:O(H)
        dfs(root,root,0,x,y);
        
        return (parentX!=parentY && levelX==levelY); 
        
    }

    private void dfs(TreeNode root,TreeNode parent, int level, int x, int y){
        
        if(root==null) return;
        
        if(root.val==x){
            parentX = parent;
            levelX  = level;
        }
        
        if(root.val==y){
            parentY = parent;
            levelY  = level;
        }
        
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }


    //BFS
    //TC:O(N)|  SC:O(N)
    //No need to take 4 variables & can prevent traversal of whole tree
    /*public boolean isCousins(TreeNode root, int x, int y) {
     
        if(root==null) return false;
        //TC: O(N) | SC:O(N)
        
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr.val==x){
                    xFound= true;
                }
                
                if(curr.val==y){
                    yFound= true;
                }
                
                if(curr.left!=null && curr.right!=null){//checking one level before whether x & y are children of same parent or not
                    
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
            
                }
             
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            
            if(xFound && yFound) return true;//x & y were not children of same parent and found on same level
            if(xFound || yFound) return false;//x & y were not children of same parent but are not on same level
        }
        
        
        
        return true;
    }*/
    
}