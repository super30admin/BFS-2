// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            Boolean found_x=false, found_y=false;
            for(int i=0;i<count;i++){
                TreeNode node=q.poll();
                if(node.left!=null && node.right!=null){
                    if(node.left.val==x && node.right.val==y){
                        return false;
                    }
                    
                    if(node.right.val==x && node.left.val==y){
                        return false;
                    }}
                    
                    if(node.val==x) found_x=true;
                    else if(node.val==y) found_y=true;
                
                
                if(node.left!=null) q.add(node.left);
                 if(node.right!=null) q.add(node.right);
            }
                if(found_x && found_y){
                    return true;
                }
                
                
            
        }
        return false;
    }
}


