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
// time Complexity : O(n)
// space complexity : O(n)
// BFS appraoch -
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size(); // we take size because we distincly req the values in the level
//             for(int i=0;i<size;i++){
//                 TreeNode curr = q.poll();
//                 if(i==size-1) result.add(curr.val);
//                 if(curr.left!=null) q.add(curr.left);
//                 if(curr.right!=null) q.add(curr.right);
//             }
//         }
//         return result;
//     }
// }

//dfs approach 
// time complexity : O(n) --> we are traversing through all components 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,0,result);
        return result;
    }
    // 1. we start from right side for rescursion 
    // 2. we check if the value is stored already for that level --> if ( size== level) that means we have not added the value yet
    // 3. because we start from right, we will take the right most value of the tree for that level 
    private void helper(TreeNode root, int level, List<Integer> result){
        // base 
        if(root==null) return ;
        //logic
        if(result.size()==level){
            result.add(root.val);
        }
        helper(root.right,level+1,result);
        helper(root.left,level+1,result);
    }
}
