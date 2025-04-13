/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CousinsOfBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> myQueue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();
        myQueue.add(root);
        parentQueue.add(null);
        boolean x_found = false;
        boolean y_found = false;
        TreeNode x_parent = null;
        TreeNode y_parent = null;

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = myQueue.poll();
                TreeNode currParent = parentQueue.poll();
                if(curr.val == x){
                    x_found = true;
                    x_parent = currParent;
                }
                if(curr.val == y){
                    y_found = true;
                    y_parent = currParent;
                }
                if(curr.left != null){
                    myQueue.add(curr.left);
                    parentQueue.add(curr);
                    }
                if(curr.right != null){
                    myQueue.add(curr.right);
                    parentQueue.add(curr);
                }
            }
            if((x_found && y_found) && (x_parent != y_parent))
                    return true;
            if(x_found || y_found)
                    return false;
        }
        return false;
    }
}