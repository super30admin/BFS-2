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



//BFS using Queue

//TC = O(n)
//SC = O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root.left);
       q.add(root.right);
        
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
            
            
        }
        
        return true;
    }
}
