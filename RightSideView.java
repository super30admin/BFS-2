/* Time Complexity :  O(n) where n is no of nodes
   Space Complexity :  O(h) where h is no of children 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
   Queue<TreeNode> q;
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList<>();
        if(root==null) return res;
        q = new LinkedList<>();
        q.add(root);
        bfs(root); 
        return res;
    }
    private void bfs(TreeNode root){
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(i==0) res.add(node.val);
                if(node.right!=null){
                    q.add(node.right);
                }
                if(node.left!=null)
                {
                    q.add(node.left);
                }
            }
        }
    }
}