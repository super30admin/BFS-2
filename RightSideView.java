/*
This solution uses a DFS approach to solve the problem. We first initiate a DFS on the right side of the root,
and store all the right children in the list. We then DFS the rest of the tree to check if there are any nodes
that are in the right view but not in the first right DFS.

Did this code run on leetcode: Yes
*/
class Solution {
    List<Integer> result;
    //Time complexity: O(n)
    //Space complexity: O(h)
    public List<Integer> rightSideView(TreeNode root) 
    {   
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        dfs(root, 0);
        
        return result;
        
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        //If the current level of the node is equal to the current size of the tree, that means we are visiting the level for the first time
        if(level == result.size())
            result.add(root.val);
        
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}