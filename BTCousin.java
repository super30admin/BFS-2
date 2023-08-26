//Time Complexity: O(N)
//Space Complexity : O(N)
public class BTCousin {
    TreeNode xParent;
    TreeNode yParent;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0, null);
        return xParent!=yParent && xLevel==yLevel;
    }
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root==null)
            return;

        if(root.val==x){
            xParent=parent;
            xLevel=level;
        }
        if(root.val==y){
            yParent=parent;
            yLevel=level;
        }

        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
    }
}
