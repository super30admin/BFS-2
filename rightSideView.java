//Time Complexity = O(n)
//Space Complexity = O(1)
/*Description : As we need to get right side nodes of the tree we will be traversing first right side
 then left side of tree. We will storing the nodes in a list. While traversing if the list's size matches 
 with the level/depth of tree then we will add the node to the list.
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,0,result);
        return result;
    }
    private void helper(TreeNode root, int level, List<Integer> result){

        //base case
        if(root == null ) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
            
        }
        level++;
        //right side traversal
        helper(root.right, level, result);
        //left side traversal
        helper(root.left,level, result);

    }
}