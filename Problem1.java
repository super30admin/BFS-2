// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//use level order traversal using queue and check the right most elemet for each level,
//use size of level and element at size-1 index in the queue is the rigthmost for that level
//add rightmost in reuslt;
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
//bfs
// class Solution {
    
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result =new ArrayList<>();
//         Queue<TreeNode> q=new LinkedList<>();
//         if(root==null)return result;
//         q.add(root);
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
//                 TreeNode current = q.poll();
//                 if(i==size-1){
//                     result.add(current.val);
//                 }
//                 if(current.left!=null) q.add(current.left);
//                 if(current.right!=null) q.add(current.right);     
//             }
//         }
//         return result;

//     }
// }
//dfs
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result =new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        if(root==null) return;
        //logic
        if(result.size()==depth){
            result.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left, depth+1);
    }
}