//Time complexity:O(n)
//Space complexity:O(n)

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        result=new ArrayList<>();
        dfs(root, 0);
        
        
        return result;
    }
    private void dfs(TreeNode root, int lvl){
        //base case
        if(root==null) return;
        
        //logic
        if(lvl==result.size()){
            result.add(root.val);
        }
        dfs(root.right,lvl+1);
        dfs(root.left,lvl+1);
    }
}