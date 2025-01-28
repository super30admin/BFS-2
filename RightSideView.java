// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//add rightmost of every level
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        if(root == null){
            return level;
        }
        queue.add(root);
        temp.add(root.val);
        while(!queue.isEmpty()){
            temp = new ArrayList<>();
            int i=queue.size();
            while(i>0){
                TreeNode node = queue.poll();
                if(node!=null){
                    queue.add(node.right);
                    queue.add(node.left);
                    temp.add(node.val);
                }
                i=i-1;
            }
            if(temp.size()>0){
                level.add(temp.get(0));
            }
        }
        return level;
    }
}