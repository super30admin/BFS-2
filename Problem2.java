import java.util.LinkedList;
import java.util.Queue;

//cousins of binary tree
// Time Complexity :O(n)
// Space Complexity :O(n) queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
We take bfs approach to find the cousins. We go on adding non null nodes in the queue. We have to check is nodes
x and y are in the same level, but diff parents. Parents are checked with root.left & root.right 
also we take size variable to check the nodes in one level at a time. 
We check if x & y are in the same level if they are found in same for loop. 
*/

public class Problem2 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        Problem2 p = new Problem2();
        System.out.println(p.isCousins(root,2,3));
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        //find the depth & parent for each node
        //by bfs
        if(root== null)
            return false;
    
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            boolean xFound = false, yFound = false;
            int size = q.size();
            for(int i = 0;i< size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }

                }
                if(curr.val == x){
                    xFound = true;
                }
                if(curr.val== y){
                    yFound = true;
                }

                
            }
            if((xFound == true && yFound == false)|| (xFound == false && yFound == true)){
                return false;
            }
            
        }
        return true;
    }
    
}
