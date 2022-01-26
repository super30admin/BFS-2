//Time Complexity: O(n)
//Space Compleity: O(n)

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
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                //Mark true if values found
                if(curr.val==x)
                    x_found=true;
                if(curr.val==y)
                    y_found=true;
                //Check if the values are left and right child i.e having same parent
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y)
                        return false;
                    if(curr.left.val==y && curr.right.val==x)
                        return false;
                }
                //Add left and right child to queue
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            //Condition to check if both x and y are found at same level then return true
            if(x_found==true && y_found==true)
                return true;
            //To check if x and y are found in different levels and return false;
            if(x_found==true || y_found==true)
                return false;
        }
        return false;
    }
}
