//time Complexity:O(nlog(n)): n to traverse the tree * reverse at least half of the tree hence adding a log(n)
// a better solution would be take a queuefor odd events and stack for even events!!

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList();
        
         List<List<Integer>> res = new  ArrayList();
         Queue <TreeNode>queue = new LinkedList<>();
         int levelOrder =0;
        
        queue.offer(root);
     
        while(!queue.isEmpty())
        {
            List <Integer> sub = new ArrayList<Integer>();
            
            int size = queue.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp = queue.poll();
                sub.add(temp.val);
                
               if(temp.left!=null)
                   queue.add(temp.left);
               if(temp.right!=null)
                   queue.add(temp.right);
            }
            if(levelOrder%2==0)
            {
                res.add(sub);
            }
            else
            {
                Collections.reverse(sub);
                res.add(sub);
            }
            levelOrder++;
        }
         return res;
    }
        
       
}
