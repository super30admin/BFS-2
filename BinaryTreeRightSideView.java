/**
 * Time Complexity - O(N) where N is the number of nodes in tree.
 * Space Complexity - O(H) where H is the height of the tree. H = N where the tree is skewed.
 *                         
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        printRightView(root, result, 0);
        return result;
    }
    
    public void printRightView(TreeNode root, List<Integer> result, int level){
        if(root == null) 
            return;
        if(result.size() == level)
            result.add(root.val);
        printRightView(root.right, result, level + 1);
        printRightView(root.left, result, level + 1);
    }
}
