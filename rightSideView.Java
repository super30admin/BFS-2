// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: by doing DFS we traverse through the right side of the array and check each level if that value for that level is not added we add that if the next value is null we check left values until that level. check if value corresponding to that level is added or no if not added then we add that element.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs( root, 0, result);    
        return result;            
    }
    private void dfs(TreeNode root, int level, List<Integer> result ){
        if(root == null) return;
        if(level == result.size()){
            result.add(root.val);
        }
        dfs(root.right,level+1,result);
        dfs(root.left,level+1,result);
    }
}