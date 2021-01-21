//Problem : 61 - Cousins in Binary Tree
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : n -> number of nodes. However as we will be storing max of all nodes at last level. Therefore space comexity will be O(n/2)+something, but constant won't matter thats why O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Use 4 variables which are x&y 'parent' and x&y 'level'. On each traversal if x and y are found store their parent and level. At the end just compare that parents of x&y are different and levels are same, then it means they are cousins otherwise they are not.

import java.util.*;

class Solution61{
    
    class TreeNode{
         int val;
         TreeNode left,right;
         TreeNode(int val){
             this.val = val;
         }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
     
        if(root==null) return false;
        //TC: O(N) | SC:O(N)
        int parentX = -1;
        int parentY = -1;
        
        int levelX  = -1;
        int levelY  = -1;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr.left!=null){
                     if(curr.left.val==x){
                        parentX = curr.val;
                        levelX  = level; 
                     }
                    
                    if(curr.left.val==y){
                        parentY = curr.val;
                        levelY  = level; 
                     }
                    
                    q.offer(curr.left);
                }
                
                if(curr.right!=null){
                     if(curr.right.val==x){
                        parentX = curr.val;
                        levelX  = level; 
                     }
                    
                    if(curr.right.val==y){
                        parentY = curr.val;
                        levelY  = level; 
                     }
                    
                    q.offer(curr.right);
                }
                
            }
            level++;
        }
        
        if(parentX!=parentY && levelX==levelY) return true;
        
        return false;
    }
}