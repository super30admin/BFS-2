//Time Complexity: O(n)
//Space Complexity: O(n); Queue Size
//Code run successfully on LeetCode.

public class Problem2_BFS {

    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)
            return false;
        
        boolean x_found = false;
        boolean y_found = false;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
           
            int size = q.size();
            for(int i =0; i < size; i++){
                
                TreeNode curr = q.poll(); 
                
                if(curr.val == x)
                    x_found = true;
                else if(curr.val == y)
                    y_found = true;
                if(curr.left != null && curr.right!= null){
                  if(curr.left.val == x && curr.right.val == y)
                    return false;
                  if(curr.left.val == y && curr.right.val == x)
                    return false;
                }   
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            if(x_found == true && y_found == false)
                return false;
            else if(y_found == true && x_found == false)
                return false;
        }
        
        return true;
    }
}
