// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class RightSide {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        //edge
        if(root == null) return result;
        dfs(root, 0);
        return result;

    }
    //dfs start on right side so right most node is stored for every level
    public void dfs(TreeNode root, int level){
        if(root == null) return;
        //add to result based on respective level
        if(level == result.size()){
            result.add(root.val);
        }
        //dfs right first
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}