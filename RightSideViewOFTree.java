// Time Complexity in DFS: O(n)
// SPace complexity: O(h) for recursive stack
public class RightSideViewOFTree {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null) return;

        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
