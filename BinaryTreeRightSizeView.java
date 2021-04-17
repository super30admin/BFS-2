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

//Approach - BFS
//Time Complexity - O(N) - number of nodes in the tree
//Space Complexity - worst case - O(N) - number of nodes in the tree - we need to store all the nodes till the last level in queue

// In BFS - in each level all elements are checked, if they are matching x or y value
// both x and y are checked if they come under same parent, if yes return false
// each node's left and right nodes are added to queue
// at the end of for loop (after each level is finished)
//              check if both x and y are found, if yes true
//              in case if x or y is found, then return false (elements not ins ame depth)



class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    if(root == null){
      return false;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean isXFound = false;
    boolean isYFound = false;

    while(!queue.isEmpty()){

      int size = queue.size();

      for(int i=0; i< size; i++){

        TreeNode node = queue.poll();

        if(node.val == x){
          isXFound = true;
        }
        if(node.val == y){
          isYFound = true;
        }

        if(node.left != null && node.right != null){
          if((node.left.val == x && node.right.val == y) ||
              node.right.val == x && node.left.val == y){
            return false;
          }
        }

        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }

      if(isXFound && isYFound){
        return true;
      }
      if(isXFound || isYFound){
        return false;
      }
    }
    // System.out.println("here3");
    return false;
  }
}













