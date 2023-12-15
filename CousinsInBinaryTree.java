import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
//        TC:O(n)
//        SC:O(2n)
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        q.add(root);
        parentQ.add(null);

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode xParent = null;
            TreeNode yParent = null;
            boolean xFound = false;
            boolean yFound = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode parent = parentQ.poll();
                if(curr.val == x){
                    xFound = true;
                    xParent = parent;
                }
                if(curr.val == y){
                    yFound = true;
                    yParent = parent;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    parentQ.add(curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }
            if(xFound && yFound) return xParent != yParent;
            if(xFound || yFound) return false;
        }
        return false;
    }

    public boolean isCousins1(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.val == x){
                    xFound = true;
                }
                if(curr.val == y){
                    yFound = true;
                }
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                    q.add(curr.left);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return false;
    }


//***********************DFS*************************
    TreeNode xParent;
    TreeNode yParent;
    int xLevel;
    int yLevel;
    public boolean isCousins2(TreeNode root, int x, int y) {
        if(root == null) return false;
        this.xParent = null;
        this.yParent = null;
        this.xLevel = -1;
        this.yLevel = -1;

        helper(root, x, y, 0, null);

        return xLevel == yLevel && xParent != yParent;
    }
    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            xLevel = level;
            xParent = parent;
        }
        if(root.val == y){
            yLevel = level;
            yParent = parent;
        }

        helper(root.left,x,y,level+1,root);
        helper(root.right,x,y,level+1,root);
    }

    // DFS with conditional recursion

    TreeNode xParent2;
    TreeNode yParent2;
    int xLevel2;
    int yLevel2;
    public boolean isCousins3(TreeNode root, int x, int y) {
        if(root == null) return false;
        this.xParent2 = null;
        this.yParent2 = null;
        this.xLevel2 = -1;
        this.yLevel2 = -1;

        helper2(root, x, y, 0, null);

        return xLevel2 == yLevel2 && xParent2 != yParent2;
    }
    private void helper2(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            xLevel2 = level;
            xParent2 = parent;
        }
        if(root.val == y){
            yLevel2 = level;
            yParent2 = parent;
        }
        if(xParent2 == null || yParent2 == null)
            helper2(root.left,x,y,level+1,root);
        if(xParent2 == null || yParent2 == null)
            helper(root.right,x,y,level+1,root);
    }
}
