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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean x_found = false;
        boolean y_found = false;
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i < n; i++){
                TreeNode curr = q.poll();
                //apply check to see if x and y found return false because siblings
                int left = 0;
                int right = 0;
                if(curr.left != null){
                    q.add(curr.left);
                    left = curr.left.val;
                } 
                if(curr.right != null){
                    q.add(curr.right);
                    right = curr.right.val;
                } 
                if((left == x && right == y)||(left == y && right== x))
                    return false; 
                level.add(curr.val);
                q.remove();
            }
            //apply checks on level to see if x found and y found and return true if found
            for(int i=0; i<level.size();i++){
                if(level.get(i)==x) x_found = true;
                if(level.get(i)==y) y_found = true;
            }
            if(x_found && y_found)
                return true;
            if(x_found || y_found)
                return false;
        }
        return false;
    }
}