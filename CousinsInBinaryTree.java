package S30.BFS_2;

/*DFS Solution
Time Complexity : O(N) - N is number of nodes in tree
Space Complexity : O(h), h is height of tree - O(n) if tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*BFS Solution
Time Complexity : O(N) - N is number of nodes in tree
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

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

    TreeNode xParent; TreeNode yParent;
    int xDepth; int yDepth;

    //DFS Solution
    public boolean isCousinsDFS(TreeNode root, int x, int y) {

        dfs(root,null,x,y,0);
        return xParent != yParent && xDepth == yDepth;
    }

    private void dfs(TreeNode root, TreeNode parent, int x, int y, int level){

        if(root == null) return;
        if(root.val == x){
            xParent = parent;
            xDepth = level;
        }
        if(root.val == y){
            yParent = parent;
            yDepth = level;
        }
        dfs(root.left,root,x,y,level+1);
        dfs(root.right,root,x,y,level+1);
    }

    //BFS Solution
    public boolean isCousinsBFS(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            if(xFound && yFound) return true;

        }
        return false;
    }

}
