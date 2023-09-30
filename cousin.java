import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;
    class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q =new LinkedList<>();
        boolean x_found = false;
        boolean y_found = false;
        q.add(root);
        //Start the BFS
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
            if(curr.left !=null && curr.right !=null){
                if(curr.left.val == x && curr.right.val == y){
                    return false;
                }
                if(curr.left.val == y && curr.right.val == x){
                    return false;
                }
            }
            if(curr.val == x){
                x_found = true;
            }
            if(curr.val == y){
                y_found = true;
            }
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        if(x_found == true && y_found == true){
            return true;
        }
        if(x_found == true || y_found == true){
            return false;
        }
   }
   return false;
}
}
    