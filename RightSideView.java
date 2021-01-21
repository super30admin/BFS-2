// Time Complexity :O(n)
// Space Complexity :O(h) h is height of the tree worst case h=n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> list;
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null) return new ArrayList<Integer>();
        list = new ArrayList<List<Integer>>();
        dfs(root,0);
        List<Integer> output = new ArrayList<Integer>();
        for(List<Integer> temp : list)
        {
            int size = temp.size();
            int x = temp.get(size-1);
            output.add(x);
        }
        
        return output;
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root==null) return;
        
        if(level==list.size())
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            list.add(temp);
        }else{
            
            List<Integer> temp = list.get(level);
            temp.add(root.val);
        }
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}