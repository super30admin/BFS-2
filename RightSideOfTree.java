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
// Approach : BFS
// Time : O(N) # visit each node
// Space : O(Wdith) # width of a tree- max of that many nodes in the queue

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0;i<level;i++){
                TreeNode curr = q.poll();
                if(i==level-1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}


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
// Approach : DFS - Recursion towards left
// Time : O(n) visiting all the nodes
// Space : O(n) # recursive space
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        if (root==null) return result;
        dfs(root,0);
        return result;
    }

    public void dfs(TreeNode root , int depth){
        // Base case
        if(root == null) return;

        // logic
        if(depth == result.size()){
            result.add(root.val);
        } else{
            // set or update the right value to the existing left
            result.set(depth, root.val);
        }

        // Recursion
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}