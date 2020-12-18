// Time - O(N)
// Space - O(H)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<Integer> result = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(i==size-1){
                    result.add(node.val);
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        
        
        return result;
    }
}
// dfs solution
class Solution {
    ArrayList<Integer> result;
    int level = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        dfs(root, level);
        
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(result.size() > level) {
            result.set(level, root.val);
        }
        else {            
            result.add(root.val);  
        }  
        dfs(root.left, level+1); 
        dfs(root.right, level+1);
    }
}
