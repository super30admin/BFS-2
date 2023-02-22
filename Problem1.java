/*
Right Side View of a tree.
approach: do BFS and add last node on each level to result.
time: O(n)
space: O(n)
 */
public class Problem1 {
    /*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++) {
                TreeNode popped = q.poll();
                if(i==size-1) {
                    res.add(popped.val);
                }
                if(popped.left!=null) q.add(popped.left);
                if(popped.right!=null) q.add(popped.right);
            }
        }

        return res;
    }

        public List<Integer> rightSideView(TreeNode root) {

    res = new ArrayList<>();
    if(root==null) return res;
    dfs(root, 0);
    return res;
    }

    private void dfs(TreeNode root, int depth) {
        if(root==null) return;

        if(res.size()==depth){
            res.add(root.val);
        }
        else {
            res.set(depth, root.val);
        }

        if(root.left!=null) dfs(root.left, depth+1);
        if(root.right!=null) dfs(root.right, depth+1);
    }

     */
}
