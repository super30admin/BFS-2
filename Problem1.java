public class Problem1 {
      //BFS
      //Space complexity : o(n)
      //Time complexity : o(n)
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){return  new ArrayList<>();}
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0; i<size;i++){
                TreeNode r1 = q.poll();
                if(r1.left!=null){
                    q.add(r1.left);
                }
                if(r1.right!=null){
                    q.add(r1.right);
                }
                if(i==size-1){
                    result.add(r1.val);
                }
            }
        }
        
        return result;
    }
    
    //DFS
          //Space complexity : o(n)
      //Time complexity : o(n)
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){return  new ArrayList<>();}
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }

        if(result.size()==level){
             result.add(root.val);
        }
  
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
