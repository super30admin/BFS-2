// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
   
    public boolean isCousins(TreeNode root, int x, int y) {
      Queue<TreeNode> q=new LinkedList<>();
      Queue<TreeNode> pq=new LinkedList<>();
      boolean depthX=false;
      boolean depthY=false;
      TreeNode parentX=null;
      TreeNode parentY=null;
      q.add(root);
      pq.add(null);
      while(!q.isEmpty()){
          int size=q.size();
          for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
          TreeNode parent=pq.poll();
               if(curr.val==x){
              parentX=parent;
              depthX=true;
          }
          if(curr.val==y){
              parentY=parent;
              depthY=true;
          }
          if(curr.left!=null){
              q.add(curr.left);
              pq.add(curr);
          }

          if(curr.right!=null){
              q.add(curr.right);
              pq.add(curr);
          }
          }
          if(depthX&&depthY){
          return parentX!=parentY;
      }
      if(depthX||depthY)return false;
    }
      
      return false;
      
    }
}

//DFS
//   helper(root,null,x,y,0);
//         return parentX!=parentY && depthX==depthY;
//     }
//     public void helper(TreeNode root,TreeNode parent,int x,int y,int depth){
//         //base
//         if(root==null)return;
//         //logic
//         if(root.val==x){
//             parentX=parent;
//             depthX=depth;
//         }
//         if(root.val==y){
//             parentY=parent;
//             depthY=depth;
//         }
//         if(parentX==null || parentY==null){
//         helper(root.left,root,x,y,depth+1);
//         }
//                 if(parentX==null || parentY==null){

//         helper(root.right,root,x,y,depth+1);}