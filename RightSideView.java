//TC O(N) - vistiting all nodes
//SC O(N) - elements in queue at particular point = elements at current level
// so at last level num of nodes = n/2 which implies O(N)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return result;
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i< size; i++){
                TreeNode cur = q.poll();
                
                //add node when processing right most element at current level
                if(i == size-1)
                    result.add(cur.val);
                
                if(cur.left != null) 
                    q.add(cur.left);
                if(cur.right != null) 
                    q.add(cur.right);
                
            }
            
        }
        
        return result;
                
    }
}