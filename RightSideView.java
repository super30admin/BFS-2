// Time complexity is the same for both BFS & DFS : O(N)
// Space for BFS - O(D) - D diameter of tree
//                      D can be up to N/2 tree nodes
// Space for DFS - O(H) - H height of tree
// Space worst case - O(N)

class RightSideView{
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(i == size-1) result.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return result;
    }

    // DFS
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        // base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}