// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class rightSideview {

    // right side view 
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        
        if(root==null)
            return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode current=queue.remove();
                
                if(size-1==i)
                    result.add(current.val);
                
                if(current.left!=null)
                    queue.add(current.left);
                
                if(current.right!=null)
                    queue.add(current.right);
                
            }
            
        }
        
        return result;
        
    }
    
    
    /* left side view
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        
        if(root==null)
            return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=1;i<=size;i++){
                
                TreeNode current=queue.poll();
                
                if(i==0)
                    result.add(current.val);
                
                if(current.left!=null)
                    queue.add(current.left);

                
            }
            
        }
        
        return result;
        
    }
    
    
    */
    
    
}
