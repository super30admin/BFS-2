/*
Thought Process: 
Use BFS approach and add the last element of the queue in each level.

TC -> O(N) where N is total number of nodes
SC -> O(K) where K is the count of leaf nodes.
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
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode polled = q.poll();
                if(i == (size-1))
                    res.add(polled.val);
                
                if(polled.left != null) q.add(polled.left);
                if(polled.right != null) q.add(polled.right);
            }
        }
        return res;
    }
}