public class IsCousin {
    // TC O(n)
    // SC O(n)
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     //       1
    //      /    \
    //     2      3
    //    /
    //   4
    //                       4,3

    //        1
    //      /   \
    //     2     3
    //      \     \
    //       4     5
                            // 5,4
      TreeNode xParent = null;
      TreeNode yParent = null;
      int xDepth = -1;
      int yDepth = -2;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return xDepth==yDepth && xParent!=yParent;
    }
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int level) {
        if (root==null)
            return;
        if (x== root.val){
            xParent=parent;
            xDepth=level;
        }else if (y== root.val){
            yParent=parent;
            yDepth=level;
        }else {
            dfs(root.left,root,x,y,level+1);
            dfs(root.right,root,x,y,level+1);
        }

    }
}



