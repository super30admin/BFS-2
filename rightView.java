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
    //TC:O(n) SC:O(n)
    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
         while(s--!=0){
               TreeNode node=q.poll();
               if(node.left!=null)q.add(node.left);
               if(node.right!=null)q.add(node.right);
                //last element in present queue   
               if(s==0)result.add(node.val);
               
            }
        }
        return result;
    }
}
