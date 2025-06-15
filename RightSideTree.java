class Solution {
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>(); 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(i==size-1){
                    result.add(node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

        return result;
        
    }
    //DFS
    //Time :O(N)
    //space : O(H)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        dfs(root,0,result);

        return result;
       
    }
    private void dfs(TreeNode root, int level,List<Integer>result){
        //base
        if(root==null) return;
        //logic 
        if(result.size()==level){
            result.add(root.val);
        }
        level+=1;
        dfs(root.right,level,result);
        dfs(root.left,level,result);
    }

}