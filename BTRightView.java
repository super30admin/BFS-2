// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        dfs(root,0);
        return result;
    }
    
    public void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        
        if(level==result.size()){
            result.add(root.val);
        }
        
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}