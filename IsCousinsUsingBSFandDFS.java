import java.util.LinkedList;
import java.util.Queue;

public class IsCousinsUsingBSFandDFS {
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

    class SolutionUsingBSF {

        //Using BFS using two queue
        //Time complexity = O(n)
        // Space complexity = O(2n)
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            Queue<TreeNode> pq = new LinkedList<>();
            q.add(root);
            pq.add(null);

            while(!q.isEmpty()){
                int size = q.size();
                boolean x_found = false;
                boolean y_found = false;
                TreeNode x_parent = null;
                TreeNode y_parent = null;
                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    TreeNode currPar = pq.poll();

                    if(curr.val == x){
                        x_found=true;
                        x_parent = currPar;
                    }
                    if(curr.val == y){
                        y_found=true;
                        y_parent = currPar;
                    }

                    if(curr.right!=null){
                        q.add(curr.right);
                        pq.add(curr);
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                        pq.add(curr);
                    }
                }
                if(x_found && y_found) return x_parent != y_parent;
                if(x_found|| y_found) return false;
            }
            return false;
        }
    }

   //Using BFS optimize solution using single queue. Space optimization
   //Time complexity = O(n)
   // Space complexity = O(n)
    class SolutionOptimizeBFS {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int size = q.size();
                boolean x_found = false;
                boolean y_found = false;
                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();

                    if(curr.val == x){
                        x_found=true;
                    }
                    if(curr.val == y){
                        y_found=true;
                    }

                    if(curr.left!=null && curr.right!=null){
                        if(curr.left.val==x && curr.right.val==y) return false;
                        if(curr.left.val==y && curr.right.val==x) return false;
                    }

                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                }
                if(x_found && y_found) return true;
                if(x_found|| y_found) return false;
            }
            return false;
        }
    }

    //Using DFS approach
    //Time complexity = O(n)
    // Space complexity = O(h)
    class SolutionDFS {
        TreeNode x_parent;
        TreeNode y_parent;
        int x_depth;
        int y_depth;
        public boolean isCousins(TreeNode root, int x, int y) {
            if(root==null)return false;
            dfs(root, x, y, 0, null);
            return x_depth==y_depth && x_parent!=y_parent;
        }

        public void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
            if(root==null) return;
            if(root.val == x){
                x_parent=parent;
                x_depth = depth;
            }
            if(root.val==y){
                y_parent=parent;
                y_depth=depth;
            }
            dfs(root.left, x,y,depth+1, root);
            dfs(root.right, x,y, depth+1, root);
        }
    }
}
