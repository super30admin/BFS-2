// Time Complexity :O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size= q.size();
            TreeNode rightNode = null;
            for(int i=0; i<q.size(); i++){
                TreeNode cur = q.poll();
                if(cur!= null){
                    rightNode = cur;
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            if(rightNode != null){
                res.add(rightNode.val);
            }
        }

        return res;
    }
}
