//BFS- isCousins
//Space complexity : o(N)
//Time complexity : o(N)
public class Problem2 {
    //BFS Approach
    boolean xFound=false;
    boolean yFound=false;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){return false;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode r1=q.poll();
                if(r1.val == x){
                    xFound=true;
                }
                 if(r1.val==y){
                    yFound=true;
                }
                if(r1.left!=null && r1.right!=null && (r1.left.val==x || r1.left.val==y) && (r1.right.val==x||r1.right.val==y)){
                    return false;
                }
                
                if(r1.left!=null){
                    q.add(r1.left);
                }
                 if(r1.right!=null){
                    q.add(r1.right);
                }
            }
            if(xFound && yFound){
                return true;
            }
            if(xFound || yFound){
                return false;
            }
        }
        return false;
    }

    //DFS Approach
    boolean xFound=false;
    boolean yFound=false;
    int xLevel=0;
    int yLevel=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){return false;}
        dfs(root,0,x,y);
        return (xLevel==yLevel) && xFound && yFound;
    }
    
    private void dfs(TreeNode root,int level,int x, int y){
        if(root==null){
            return;
        }
        
         if(root.left!=null && root.right!=null && (root.left.val==x || root.left.val==y) && (root.right.val==x||root.right.val==y)){
                   return;
                }
        if(root.val==x){
            xFound=true;
            xLevel=level;
        }
        
         if(root.val==y){
            yFound=true;
            yLevel=level;
        }
        
        dfs(root.left,level+1,x,y);
        dfs(root.right,level+1,x,y);
    }
}
