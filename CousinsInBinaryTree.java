//Time Complexity: O(n)
//Space Complexity: O(h)
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i=0; i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x&&curr.right.val==y) return false;
                    if(curr.left.val==y&&curr.right.val==x) return false;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(x_found&&y_found){
                return true;
            }
        }


        return false;

    }
}
