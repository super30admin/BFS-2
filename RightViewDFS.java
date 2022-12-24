// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new LinkedList<>();
        
        if(root == null){
            return result;
        }
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null){
            return;
        }
        
        //logic
        //Add the element on the left and replace it with next element on the same level
        if(level == result.size()){
            result.add(root.val);
        }else{
            result.set(level, root.val);
        }
        
        //Go to the left first 
        dfs(root.left, level+1);
        
        //Go to the right to replace the left elements
        dfs(root.right, level+1);
    }
}