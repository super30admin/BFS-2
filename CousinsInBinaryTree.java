import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public class TreeNode {
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

    class Solution1 {
        public boolean isCousins(TreeNode root, int x, int y) {
            // BFS approach
            // TC - O(n) where n is number of nodes in the tree
            // SC - O(n) where h is the height of the tree
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                boolean x_found = false, y_found = false;

                for (int i=0; i<size; i++) {
                    TreeNode curr = q.poll();
                    assert curr != null;
                    if (curr.val == x) x_found = true;
                    if (curr.val == y) y_found = true;

                    // check if x & y belong to same parent
                    if(curr.left!=null && curr.right!=null) {
                        if (curr.left.val == x  && curr.right.val == y) return false;
                        if( curr.left.val == y && curr.right.val == x) return false;
                    }

                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);


                } // end of for loop
                if (x_found && y_found) return true;
                if (x_found || y_found) return false;
            }
            return true;
        }
    }

    class Solution2 {
        // DFS approach
        // TC - O(n) where n is number of nodes in the tree
        // SC - O(h) where h is height of the tree
        TreeNode x_parent;
        TreeNode y_parent;
        int x_depth;
        int y_depth;

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root==null) return false;
            dfs(root,x,y,0,null);
            return x_parent!=y_parent && x_depth==y_depth;
        }

        private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
            // base
            if(root ==null) return;

            //logic
            if(root.val ==x){
                x_parent = parent;
                x_depth = depth;
            }
            if(root.val==y){
                y_parent = parent;
                y_depth = depth;
            }
            dfs(root.left,x,y,depth+1,root);
            dfs(root.right,x,y,depth+1,root);
        }
    }

}
