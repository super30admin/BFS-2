//binary right side view
// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(n) queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
BFS Approach , it uses queue to just go on add left and right nodes if they
are not null. When the index is size-1, that means that is the right side of the tree, if 
there is right side, we add that in list 

*/

import java.util.*;
public class Problem1{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Problem1 p = new Problem1();
        System.out.println(p.rightSideView(root));
        

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode curr = q.poll();
                if(i== size-1){
                    res.add(curr.val);
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                

            }
        }
        return res;

    }
}