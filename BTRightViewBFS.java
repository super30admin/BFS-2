//Time Complexity = O(N), where N is the number of nodes
//Space Complexity = O(D), where D is the diameter of the tree
//Did it run successfully on Leetcode: Yes

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
class BTRightViewBFS {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        result = new ArrayList<Integer>();
//         BFS
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             int length = queue.size();

             for(int i=0; i<length; i++) {
                 TreeNode node = queue.poll();
                 if(i==length-1){
                     result.add(node.val);
                 }
                 if(node.left!= null){
                     queue.add(node.left);
                 }
                 if(node.right!= null){
                     queue.add(node.right);
                 }
             }
         }
         return result;

//       DFS
        dfs(root, 0);
        return result;
    }


}