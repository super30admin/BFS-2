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
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result=new ArrayList<>();
      leftView(root,result,0);
      return result;  
    }
    public void leftView(TreeNode curr,List<Integer> r,int depth){
        if(curr==null){
            return;
        }
        if(r.size()==depth){
            r.add(curr.val);
        }
        
        leftView(curr.right,r,depth+1);
        leftView(curr.left,r,depth+1);
        
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
