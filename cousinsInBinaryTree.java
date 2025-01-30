import java.util.LinkedList;
import java.util.Queue;
//TC: O(n)
//SC: O(n)
//BFS
class cousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean x_found = false;
        boolean y_found = false;
        q.add(root);
        while (!q.isEmpty()) {
            //size is responsible for checking the level
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                //30-37 is for checking they doesn't belong to same parent
                if(curr.left != null && curr.right != null){
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
            //Checking if both are found in same level and parent isn't same then only return true
            if(x_found == true && y_found == true){
                return true;
            }
            //if just one is found in same level we should return false
            if(x_found == true || y_found == true){
                return false;
            }
        }
        return true;

    }
}