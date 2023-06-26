package BFS2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * We do normal BFS and maintain the level while processing using size of the queue. At the end of each level we 
 * take the associated no.
 * 
 * Time Complexity : O(n) where n is the no of nodes
 * 
 * 
 * Space Complexity : O(n) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

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

public class Problem1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue <TreeNode> q =new LinkedList<>();

        if(root==null)
            return ans;

        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.left!=null)
                   q.add(curr.left);

                 if(curr.right!=null)
                    q.add(curr.right);
                
                if(i==size-1){
                    ans.add(curr.val);
                }
            }
        }

        return ans;
    }
}
