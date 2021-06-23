import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList();
        if(root == null) return res;
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();
            for(int i=count; i>0; i--){
                TreeNode curr = q.poll();
                if(i==count) res.add(curr.val);
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);
            }
        }
        return res;
    }
}
