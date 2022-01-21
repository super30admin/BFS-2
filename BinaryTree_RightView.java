// Time Complexity : O(n)
// Space Complexity : O(n) - BFS solution, O(h) - DFS solution
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_RightView {

    static class TreeNode {
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

    public static List<Integer> rightSideViewUsingBFS(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);

        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = bfsQ.poll();
                if(curr.left != null) bfsQ.add(curr.left);
                if(curr.right != null) bfsQ.add(curr.right);

                if(i == size - 1) result.add(curr.val);
            }
        }

        return result;
    }

    public static List<Integer> leftSideViewUsingBFS(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);

        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = bfsQ.poll();
                if(curr.left != null) bfsQ.add(curr.left);
                if(curr.right != null) bfsQ.add(curr.right);

                if(i == 0) result.add(curr.val);
            }
        }
        return result;
    }

    List<Integer> result;
    public List<Integer> rightSideViewUsingDFS(TreeNode root) {

        result = new ArrayList<>();

        if(root == null) return result;

        dfs_right_helper(root, 0);

        return result;
    }

    private  void dfs_right_helper(TreeNode root, int level){

        //base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level, root.val);
        }

        dfs_right_helper(root.left, level + 1);
        dfs_right_helper(root.right, level + 1);

    }


    public List<Integer> leftSideViewUsingDFS(TreeNode root) {

        result = new ArrayList<>();

        if(root == null) return result;

        dfs_left_helper(root, 0);

        return result;
    }

    private  void dfs_left_helper(TreeNode root, int level){

        //base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        }

        dfs_left_helper(root.left, level + 1);
        dfs_left_helper(root.right, level + 1);

    }
    public static void main(String[] args) {

        TreeNode t15 = new TreeNode(15, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t2 = new TreeNode(2, null, t15);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, null, t4);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println("rightSideViewUsingBFS  : " +  rightSideViewUsingBFS(t1));

        System.out.println("leftSideViewUsingBFS  : " +  leftSideViewUsingBFS(t1));

        System.out.println("rightSideViewUsingDFS  : " + new BinaryTree_RightView().rightSideViewUsingDFS(t1));

        System.out.println("leftSideViewUsingDFS  : " + new BinaryTree_RightView().leftSideViewUsingDFS(t1));
    }
}
