//BFS solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                //process babies
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }

        return result;
        
    }
}

 //DFS solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //if(root==null) return result;
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root, int level,List<Integer> result){
        //base
        if(root==null) return;
        //logic
        if(level==result.size()){
            result.add(root.val);
        }
        dfs(root.right,level+1,result);
        dfs(root.left,level+1,result);

    }
}