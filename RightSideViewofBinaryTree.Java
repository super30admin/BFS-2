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
// BFS solution
//TC: o(N)
//SC: o(H) h is height of the tree
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();    
            for(int i=0;i<size;i++){
             TreeNode curr = q.poll();
                // i== size -1 is right side view of tree
                //i== 0 is  left side view of the tree
                if(i == size-1)
                {
                    result.add(curr.val);
                }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            }
            

        }
        
        return result;
    }
}
