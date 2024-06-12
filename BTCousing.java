// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// BFS
class Solution {
    
    private int depthX =-1;
    private int depthY =-1;
    
    private TreeNode parentX = null;
    private TreeNode parentY= null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        Queue<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
        q.add(new Pair(root, root));
        int depth =1;
        int depthX =-1;
        int depthY =-1; 
        TreeNode parentX = null;
        TreeNode parentY= null;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair<TreeNode, TreeNode> pair = q.poll();
                
                if(pair.getKey().val==x){
                    depthX = depth;
                    parentX = pair.getValue(); 
                } 
                if(pair.getKey().val==y){
                    depthY = depth;
                    parentY = pair.getValue(); 
                }
                if(pair.getKey().left !=null)
                    q.add(new Pair(pair.getKey().left, pair.getKey()));
                if(pair.getKey().right !=null)
                    q.add(new Pair(pair.getKey().right, pair.getKey()));
            }
            depth++;
        } 
        return (depthY==depthX && parentX.val!=parentY.val);
    }
