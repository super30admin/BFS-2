// Time - 0(n)
// Space - O(n)
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
        Queue<TreeNode> q = new LinkedList<>();
        boolean foundx;
        boolean foundy;
        int parentx;
        int parenty;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            foundx = false;
            foundy =false;
            parentx = -1;
            parenty = -1;
            for(int i=0;i<n;i++){
                TreeNode no = q.poll();
                if(no.left!=null){
                    if(no.left.val==x){
                        parentx = no.val;
                        foundx = true;
                    }
                    if(no.left.val==y){
                        parenty = no.val;
                        foundy = true;
                    }
                    q.add(no.left);
                }
                if(no.right!=null){
                    if(no.right.val==x){
                        parentx = no.val;
                        foundx = true;
                    }
                   if(no.right.val==y){
                       parenty = no.val;
                        foundy = true;
                    }
                    q.add(no.right);
                }
                if(foundx && foundy && parentx==parenty){
                    return false;
                }
            }
            if(foundx && foundy){
                    return true;
                }
        }
        return false;
    }
}
