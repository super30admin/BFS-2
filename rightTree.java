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

//Time Complexity: O(n).
//Space Complexity: O(H) //leaf nodes.
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        Queue<TreeNode> oq = new LinkedList<>();
        result = new ArrayList<>();
        
        oq.add(root);
        while(!oq.isEmpty()){
            int size = oq.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = oq.poll();
                if(curr.left != null)
                    oq.add(curr.left);
                if(curr.right != null)
                    oq.add(curr.right);
                if(i == size - 1)
                    result.add(curr.val);
            }
        }
        
        return result;
    }
}