// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: DFS is much preferred, as recursive calls are easier to understand
// as the base cases are clear

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i<l; i++){
                TreeNode n = q.poll();
                if(i == l-1){
                    res.add(n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
        }
        return res;
    }

    //DFS
    // at every node if size == lvl then add
    // for left side view,add -- if size!=lvl then res.set(lvl, root.val)
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;

        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int lvl){
        if(root == null) return;

        if(res.size() == lvl)
            res.add(root.val);

        dfs(root.right, lvl+1);
        dfs(root.left, lvl+1);
    }
}
