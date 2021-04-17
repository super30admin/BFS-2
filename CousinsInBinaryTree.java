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

//Apprach - BFS
//Time Complexity - O(N) - no of nodes in the tree
//Space Complexity - O(H) - height of the tree
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightSideNodes = new ArrayList<>();

    if(root == null){
      return rightSideNodes;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

      TreeNode node = null;
      int size = queue.size();

      for(int i=0; i<size; i++){
        node = queue.poll();

        if(node.left != null){
          queue.add(node.left);
        }

        if(node.right != null){
          queue.add(node.right);
        }
      }
      rightSideNodes.add(node.val);
    }

    return rightSideNodes;
  }
}