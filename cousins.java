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
    TreeNode rootx;
    TreeNode rooty;
    boolean flagx=false;
    boolean flagy=false;
    
    public boolean isCousins(TreeNode root, int x, int y) {
      Queue<TreeNode> q = new LinkedList<>();
      TreeNode t=null;
      if(root!=null)
       q.offer(root);
       while(!q.isEmpty()){
          
        int s = q.size();
        for(int i=0;i<s;i++){
             t=q.poll();
             if(t.left!=null){
             if(t.left.val==x)
             rootx=t;
             if(t.left.val==y)
             rooty=t;
             q.offer(t.left);
             }
             if(t.right!=null){
             q.offer(t.right);
             if(t.right.val==x)
             rootx=t;
             if(t.right.val==y)
             rooty=t;
             q.offer(t.right);
             }
            if(t.val==x)
             flagx=true;
             if(t.val==y)
             flagy=true;
             
        } if (flagx==false || flagy==false){
            flagx=false;
            flagy=false;
        }
            

       }

       if(rootx!=rooty && flagx==true && flagy==true)
         return true;
        else
        return false;
    }

   
  

    
}