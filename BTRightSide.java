//time complexity:O(n)
//space complexity: O(height)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level)
    {
        if(root==null) return;
        if(result.size()==level)
        {
            result.add(root.val);//when the level of the tree and
            //size of the list is same add the element to list
        }
        dfs(root.right,level+1);//right recursive call 
        dfs(root.left,level+1);//then left recursive call
    }
}