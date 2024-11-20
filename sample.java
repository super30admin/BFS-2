//Time Complexity - O[N]
//Space Complexity - O[N]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList();
        help(root, l, 0);
        return l;
    }
    
    public void help(TreeNode root, List<Integer> l, int level){
        if(root == null)
            return;
        if(l.size() == 0 || l.size() <= level){
            l.add(root.val);
        }
		//add the right-most side first.
        help(root.right, l, level+1);
        help(root.left, l, level+1);
    }
}