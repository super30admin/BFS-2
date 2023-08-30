import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideTreeView {
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

    //Using BSF approach
    //Time complexity = O(n)
    // Space complexity = O(n)
    class SolutionUsingBFS {
        public List<Integer> rightSideView(TreeNode root) {
            //Using BSF approach
            List<Integer> result = new ArrayList<>();
            //null check
            if(root==null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    if(i==size-1){ //taking the last index of the level i.e. extreme right side
                        result.add(curr.val);
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
            return result;
        }
    }

    //Using DFS approach
    //Time complexity = O(n)
    // Space complexity = O(n)
    class SolutionUsingDFS {
        public List<Integer> rightSideView(TreeNode root) {
            //Using DFS approach
            List<Integer> result = new ArrayList<>();
            dfs(root, 0, result);
            return result;
        }
        public void dfs(TreeNode root, int height, List<Integer> result){
            if(root==null) return;
            if(height==result.size()){
                result.add(root.val);
            }
            dfs(root.right, height+1, result);
            dfs(root.left, height+1, result);
        }
    }
}
