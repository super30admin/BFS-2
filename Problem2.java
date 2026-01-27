//Using BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue <TreeNode> q= new LinkedList<>();
        //pq=parent queue
        Queue <TreeNode> pq=new LinkedList<>();
        q.add(root);
        pq.add(null);
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            TreeNode x_parent=null;
            TreeNode y_parent=null;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                TreeNode pcurr=pq.poll(); //pcurr=parentcurr
                if(curr.val==x){
                    x_found=true;
                    x_parent=pcurr;
                }
                if(curr.val==y){
                    y_found=true;
                    y_parent=pcurr;
                }
                //process left baby
                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                //process lright baby
                if(curr.right!=null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if(x_found && y_found){
                return x_parent != y_parent;
            }
            if(x_found || y_found){
                return false;
            }
        }
        return false;
        
    }
}

//Using DFS
class Solution {
    private int x_depth;
    private int y_depth;
    private TreeNode x_parent;
    private TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return x_depth==y_depth && x_parent != y_parent;    
    }
    private void dfs(TreeNode root,TreeNode papa,int x,int y,int level){
        //base
        if(root==null) return;
        //logic
        if(root.val==x){
            x_depth=level;
            x_parent=papa;
        }
        if(root.val==y){
            y_depth=level;
            y_parent=papa;
        }
        dfs(root.left,root,x,y,level+1);
        dfs(root.right,root,x,y,level+1);
    }
}