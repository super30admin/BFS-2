package BFS-2;

public class problem1 {
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
       //dfs
        helper(root, 0);
        
        return result;
    }
    
    public void helper(TreeNode root, int lvl){
        if(root == null) return;
        
        if(lvl == result.size()){
            result.add(root.val);
        }else{
            result.set(lvl, root.val);
        }
        helper(root.left, lvl+1);
        helper(root.right, lvl+1);
        
    }
}
