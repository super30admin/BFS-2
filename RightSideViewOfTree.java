import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode - 199
//TC - O(N)
//SC - O(H)
public class RightSideViewOfTree {

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
    //BFS approach
    //TC - O(N)
    //SC - O(H)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(i == size - 1) { // i == 0 for left side view of tree
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }

    /*
    //DFS approach with right recursive call first
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level) {
        //base
        if(root == null) return;

        //logic
        if(result.size() == level) {
            result.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
     */

    /*
    //DFS approach with left recursive call first
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level) {
        //base
        if(root == null) return;

        //logic
        if(result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
          }
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
     */
}
