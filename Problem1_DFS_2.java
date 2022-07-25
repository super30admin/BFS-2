//Time Complexity: O(n)
//Space Complexity: O(h); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_DFS_2 {

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        
        if(root == null)
            return;
        
        if(result.size() == lvl)
        {
            result.add(root.val);
        }
        
        else{
            result.set(lvl, root.val);
        }
        
        dfs(root.left, lvl +1);
        dfs(root.right, lvl +1);
    }
}
