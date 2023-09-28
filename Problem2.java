// Time Complexity : O(n) traverses through all nodes of tree in worst case
// Space Complexity : O(n) in worst case for queue space. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }

        boolean x_found = false;
        boolean y_found = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false;
                    }
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

        return x_found && y_found;
    }
}
