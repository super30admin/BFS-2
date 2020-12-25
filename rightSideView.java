// BFS Solution
 // Time Complexity: O(N)
 // Space Complexity:  O(H) where H is Height of tree
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
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        q.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int last = 0;
            for(int i=0; i< size; i++){
                TreeNode curr = queue.poll();
                last = curr.val;
                //add the left node
                if(curr.left != null){
                    queue.add(curr.left);
                }
                //add the right node
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
             result.add(last);
        }
        return result;
    }
}
//DFS Solution
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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null)
            return;
        //add the root node
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}