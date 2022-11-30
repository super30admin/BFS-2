// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean xFound= false, yFound=false;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll(); 
                if(curr.val==x){
                    xFound=true;
                }
                if(curr.val==y){
                    yFound=true;
                }
                
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }else if(curr.left.val==y && curr.right.val==x){
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
            
            if(xFound==true && yFound==true) return true;
            if(xFound==true || yFound==true) return false;
            
        }
        return false;
    }
}