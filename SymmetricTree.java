//TC = O(n)
//Space = O(1)

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }
    
    private void dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        
        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }
        
        
        //logic
        dfs(left.left, right.right);
        //st.pop
        dfs(left.right, right.left);
        //st.pop
   
    }
}
