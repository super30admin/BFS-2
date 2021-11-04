// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int size=0;
        
        while(!queue.isEmpty()){
            size=queue.size();
            boolean xfound=false;
            boolean yfound=false;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }
                    
                     if(curr.left.val==y && curr.right.val==x){
                        return false;
                    }
                }
                
                if(curr.val==x){
                    xfound=true;
                }
                
                if(curr.val==y){
                    yfound=true;
                }
                
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            
            if(xfound && yfound)return true;
        }
        return false;
    }
}