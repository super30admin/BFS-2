// Time Complexity :O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    class TreeNode {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean xFound= false, yFound=false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.val == x){
                    xFound = true;
                }
                if(cur.val == y){
                    yFound = true;
                }

                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y) return false;
                    if(cur.right.val == x && cur.left.val == y) return false;
                }

                if(cur.left != null){
                    q.add(cur.left);
                }

                if(cur.right != null){
                    q.add(cur.right);
                }
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return true;
    }
}
