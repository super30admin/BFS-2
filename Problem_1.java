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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode curr=null;
            for(int i =0;i<size;i++){
               // if(i==size-1) res.add(curr.val);
                curr= q.poll();
                if(curr.left!=null){
                    q.add(curr.left);}
                 if(curr.right!=null){
                    q.add(curr.right);}
            }
            res.add(curr.val);
        }
        return res;
    }
}