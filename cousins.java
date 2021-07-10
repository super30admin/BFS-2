Time Complexity : O(N)
Space Complexity : O(N)

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
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean foundx = false;
            boolean foundy = false;
            int xparent = -1;
            int yparent = -1;
            for(int i = 0; i<size; i++)
            {
                TreeNode p = q.poll();
                 TreeNode left = p.left; // check forLeft
                    if(left!=null){
                        q.add(left);
                        if(left.val==x){
                            foundx=true;
                            xparent=p.val;
                        }else if(left.val==y){
                            foundy=true;
                            yparent=p.val;
                        }
                    }
                
                TreeNode right = p.right; // check for right
                    if(right!=null){
                        q.add(right);
                        if(right.val==x){
                            foundx=true;
                            xparent=p.val;
                        }
                        else if(right.val==y){
                            foundy=true;
                            yparent=p.val;
                        }
                    }
            }

            if(foundx==foundy && yparent != xparent){ // if both x and y don't have same parents return true
                return true;
            }        
        }
        return false;
    }
}