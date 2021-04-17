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
//Time Complexity: O(n)
//Space Complexity:O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int lvl=0,l1=-1,l2=-2;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();
                if(curr.val==x) {l1=lvl;}
                if(curr.val==y) {l2=lvl;}
                if((curr.left!=null && curr.right!=null) &&((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x))) return false;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            lvl++;
        }
        System.out.print(l1+" "+l2);
        if(l1==l2) return true;
        return false;
    }
}