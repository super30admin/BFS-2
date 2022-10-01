import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static class TreeNode { int val;
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

    public static class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            // BFS Approach
            // TC - O(n) where n is number of nodes in the tree
            // SC - O(n) where h is the height of the tree
            List<Integer> result = new ArrayList<>();
            if (root==null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    if(i==size-1){
                        result.add(curr.val);
                    }
                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            // DFS Approach - Visit Right node first
            // TC - O(n) where n is number of nodes in the tree
            // SC - O(h) where h is height of the tree
            List<Integer> result = new ArrayList<>();
            if (root==null) return result;
            dfs(root,0,result);
            return result;
        }

        private void dfs(TreeNode root, int depth, List<Integer> result){
            // base
            if (root==null) return;

            // logic

            if (depth==result.size()){
                result.add(root.val);
            }
            dfs(root.right, depth+1, result);
            dfs(root.left, depth+1, result);
        }
    }

    class Solution3 {
        public List<Integer> rightSideView(TreeNode root) {
            // DFS Approach - Visit left  node first
            // TC - O(n) where n is number of nodes in the tree
            // SC - O(h) where h is height of the tree
            List<Integer> result = new ArrayList<>();
            if (root==null) return result;
            dfs(root,0,result);
            return result;
        }

        private void dfs(TreeNode root, int depth, List<Integer> result){
            // base
            if (root == null) return;

            // logic

            if (depth == result.size()){
                result.add(root.val);
            }
            else{
                result.set(depth,root.val);
            }
            dfs(root.left, depth+1, result);
            dfs(root.right, depth+1, result);
        }
    }
    
}
