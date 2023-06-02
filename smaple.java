class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        DFS(root,0);
        return result;
        
    }
    public void DFS (TreeNode root, int level){
        //base
        if(root == null)return;
        
        if(level == result.size()){
            result.add(root.val);
        }else{
            //replace
            result.set(level,root.val);
        }
        //logic
        DFS(root.left, level +1);
        DFS(root.right, level +1);
                
    }
    
}
//DFS right view giong right first

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean XFound = false;
        boolean YFound = false;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i<size; i++){
                root = que.poll();                
                if(root.val == x){
                   XFound = true; 
                }
                if(root.val == y){
                    YFound = true;
                }
                if(root.left != null && root.right != null){
                    if(root.left.val == x && root.right.val == y) return false;
                    if(root.left.val == y && root.right.val == x) return false;
                }                
                if(root.left != null) que.add(root.left);
                if(root.right != null) que.add(root.right);
            }
            if(XFound && YFound) return true;
            if(XFound || YFound ) return false;
        }
        return false;
    }
}
