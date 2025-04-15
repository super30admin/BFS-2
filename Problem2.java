import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
    //Approach 3 - Using DFS 
    
    
    //Approach 2 - Don't maintain parent queue, check if they are siblings return false
    Queue <TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean x_found = false, y_found = false;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){                
            TreeNode curr = q.poll();

            //Checking child of same parent or not
            if(curr.left != null & curr.right !=null){
                if(curr.left.val == x && curr.right.val == y ) return false;
                if(curr.left.val == y && curr.right.val ==x) return true;
            }

            if(curr.left != null){
                q.add(curr.left);
            }
            
            if(curr.right != null){
                q.add(curr.right);
            }

            if (curr.val == x){
                x_found = true;
            }
            if (curr.val == y){
                y_found = true;
            }
        }
        
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return true;   
    }
}
