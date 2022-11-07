// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    //Approach3 BFS
    List<Integer> result;
    Queue<TreeNode> q;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        //bfs(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(i==size-1)result.add(node.val);

                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }

        }
        return result;
    }

    //Approach2 DFS left side
    // List<Integer> result;
    // public List<Integer> rightSideView(TreeNode root) {
    //     result = new ArrayList<>();
    //     if(root == null) return result;
    //     dfs(root,0);
    //     return result;
    // }
    // public void dfs(TreeNode root, int level){
    //     //base
    //     if(root == null) return;
    //     //logic
    //     if(result.size()==level){
    //         result.add(root.val);
    //     }else{
    //         result.set(level,root.val);
    //     }
    //     dfs(root.left,level+1);
    //     dfs(root.right,level+1);
    // }

    //Approach1 DFS right side
    // List<Integer> result;
    // public List<Integer> rightSideView(TreeNode root) {
    //     result = new ArrayList<>();
    //     if(root == null) return result;
    //     dfs(root,0);
    //     return result;
    // }
    // public void dfs(TreeNode root, int level){
    //     //base
    //     if(root == null) return;
    //     //logic
    //     if(result.size()==level)result.add(root.val);
    //     dfs(root.right,level+1);
    //     dfs(root.left,level+1);
    // }
}
