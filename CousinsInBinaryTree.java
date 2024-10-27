class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xf=false,yf=false;
        TreeNode xp=null,yp=null;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<TreeNode> pq=new LinkedList<>();
        q.add(root);
        pq.add(null);
        
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                TreeNode parent=pq.poll();
                if(curr.val==x){
                    xf=true;
                    xp=parent;
                }
                if(curr.val==y){
                    yf=true;
                    yp=parent;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            
            if(xf && yf) return xp!=yp;
            if(xf || yf) return false;
        }
        return false;
    }
}