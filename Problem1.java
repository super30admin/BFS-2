package BFS-2;
// TC: O(n)
// SC: O(height)
public class Problem1 {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result=new ArrayList<>();
        dfs(root, 0);
        return result;
    }
     public void dfs(TreeNode root, int level){
        if(root==null) return;
        if(result.size() == level) result.add(root.val);
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
