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
/*
method 2 is dfs recursive approach.
time complexity: O(n)
space complexity : O(h), (under the hood i.e. recursion stack)
*/
class RightSideView {
    
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null)return result;
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode node, int level){
        //base case
        if(node == null){
            return;
        }
        
        //main logic
        //inorder traversal of root, right, left
        if(level == result.size()){
            result.add(node.val);
        }
        dfs(node.right, level+1);
        dfs(node.left, level+1);
    }
}
/*
method 1 : Iterative BFS approach, where is traverse level by level
time complexity: O(n), traversing all the nodes
space complexity : O(n/2), at each we just maintaining the curr level nodes in queue
*/
// class Solution {
    
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
        
//         if(root == null)return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
        
//         queue.add(root);//add root to queue
//         while(!queue.isEmpty()){
//             int size = queue.size(); //take the size of curr queue
            
//             for(int i = 0; i < size;i++){
//                 //pop the front node
//                 TreeNode node = queue.poll();
//                 //if i == size-1, this means that the node is right most node of that level, so add it to result.
                
//                 if(i == size - 1){
//                     result.add(node.val);
                   
//                 }
//                 //continue the bfs
//                  if(node.left!= null)queue.add(node.left);
//                  if(node.right != null) queue.add(node.right);
//             }
//         }
        
//         return result;
//     }
// }