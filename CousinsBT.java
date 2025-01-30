
//Time Complexity : O(n)
// Space Complexity: O(1)

public class CousinsBT {

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

        int depthx =0, depthy=0, parentx=0, parenty =0;
        public boolean isCousins(TreeNode root, int x, int y) {

            checkCousins(root,null, x, y, 0);
            checkCousins(root,null, x, y, 0);

            if(depthx == depthy && parentx != parenty){
                return true;
            }
            return false;
        }

        public void checkCousins(TreeNode root, TreeNode parent, int x, int y, int lvl){
            if(root == null){
                return;
            }

            if(root.val == x ){
                depthx = lvl;
                if(parent != null){
                    parentx =  parent.val;
                }
            }
            if(root.val == y ){
                depthy =lvl;
                if(parent != null){
                    parenty =  parent.val;
                }
            }
            checkCousins(root.left, root, x, y, lvl+1);
            checkCousins(root.right, root, x, y, lvl+1);
        }

}
