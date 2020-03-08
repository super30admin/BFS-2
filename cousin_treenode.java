// Time Complexity : O(n)
// Space Complexity : O(n), bfs queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
       
        int levelX = -1;
        int levelY = -1;
        
        TreeNode parentX = null;
        TreeNode parentY = null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i =0; i<size; i++){
                
                TreeNode currentNode = q.poll();
                
                if(currentNode.left != null){
                    if(currentNode.left.val == x){
                        parentX = currentNode;
                        levelX = level;
                    }else if(currentNode.left.val == y){
                        parentY = currentNode;
                        levelY = level;
                    }
                    
                    q.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    if(currentNode.right.val == x){
                        parentX = currentNode;
                        levelX = level;
                    }else if(currentNode.right.val == y){
                        parentY = currentNode;
                        levelY = level;
                    }
                    
                    q.add(currentNode.right);
                }
            }
            
            level++;
        }
        
        if (parentX != null && parentY != null && (parentX.val != parentY.val) && levelX == levelY) {
            return true;
        }
        return false;
        
       //return parentX == parentY && parentX.val != parentY.val && levelX == levelY; 
    }
}