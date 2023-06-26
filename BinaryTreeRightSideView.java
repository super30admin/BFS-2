// Time Complexity :O(n) where n is the number of nodes
// Space Complexity :O(n) where n is the number of nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;

        while(!q.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            for(int i =0; i< size; i++){
                TreeNode current = q.poll();
                ll.add(current.val);
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
            size = q.size();
            result.add(ll.get(ll.size()-1));
        }
        return result;
    }
}