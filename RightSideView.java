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
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res= new ArrayList<>();
        helper(root,0);
        return res;
//         if(root == null)
//         {
//             return new ArrayList<>();
//         }
        
//         List<Integer> res = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int size;
//         while(!q.isEmpty())
//         {
//           size = q.size();
//           while(size!=0){
//           TreeNode front = q.poll();
//               if(size==1)
//               {
//                   res.add(front.val);
//               }
//              // res.add(front.val);  
//              if(front.left!=null)
//              {
//                 q.add(front.left);
//             }
//            if(front.right!=null){             
//                q.add(front.right);
//            }
//               size--;
//            }
//         }
//         return res;
            
  }
        private void helper(TreeNode root, int lvl)
        {
            if(root==null)
            {
                return;
            }
            
            if(res.size()==lvl)
            {
                res.add(root.val);
            }
            
            
            helper(root.right,lvl+1);
            helper(root.left,lvl+1);
        }
        
         
}
    