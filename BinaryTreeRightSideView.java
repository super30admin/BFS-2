/**
 * Definition for a binary tree node.
 */ 
 
  /*Approach
  1) the right side is the right most node of the tree
  2) if right node is not present then it is the rightmost left node of the tree
  3) In this we traverse using BFS and use a hack
  4) we travel through each level, thus for every level we update the value

                1
                /\
               2  3
                \ /
                4 5
                  /
                 6
  5) In this tree, the rightmost view would he [1,3,5,6]
  6) thus for every level we use a value to update the latest node.val
  thus val will be overridden with the latest value-> in 4,5 level val would be 4 and then updated with 5, thus giving the right most view

  */

 import java.util.*; 

class BinaryTreeRightSideView {

    public class TreeNode {
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
    public List<Integer> rightSideView(TreeNode root) {
       
        
        
        List<Integer> res = new ArrayList<>();
        
        if(root==null)
        {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            
            int val =0;
            int level =queue.size();
            for(int i=0;i<level;i++)
            {
                TreeNode node =queue.poll();
                val = node.val;
                
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                
            }
            
            res.add(val);
        }
        
        return res;
    }
}