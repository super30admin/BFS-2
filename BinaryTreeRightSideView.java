//Problem : 60 - Binary Tree Right Side View
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : O(H), H stands for height of tree in terms of recursive stack.
//                    In terms of queue-O(n), n -> number of nodes. However as we will be storing max of all nodes at last level. Therefore space comexity will be O(n/2)+something, but constant won't matter thats why O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Can be done using Recursion(DFS) or Queue(BFS). While doing level order traversal using DFS, increment level & pass it on each call. If list size is equal to level, then just create the new List and for adding element in the list use level as an index;

import java.util.*;

class Solution60{
    
    class TreeNode{
         int val;
         TreeNode left,right;
         TreeNode(int val){
             this.val = val;
         }
    }

    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        
        //output list
        res = new ArrayList<>();
        
        if(root==null) return res;
        
        //BFS
        /*Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr.left!=null) q.offer(curr.left);
                
                if(curr.right!=null) q.offer(curr.right);
                
                //if node is last elemnet of that level
                if(i==size-1) res.add(curr.val);
                
            }
        }*/
         
        helper(root,0);
        return res;
    }
    //DFS
    private void helper(TreeNode root,int level){
        
        if(root==null) return;
        
        if(res.size()==level){
            res.add(root.val);
        }
        
        helper(root.right,level+1);
        helper(root.left,level+1);
        
        
    }
}