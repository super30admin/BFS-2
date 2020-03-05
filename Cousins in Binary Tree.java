// Time Complexity :o(N) 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

///**
 /* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//SOLUTION RECURSIVE

class Solution {
       TreeNode ParentX=null;
        TreeNode ParentY=null;
        int levelY=0,levelX=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root ==null) return false; 
        int level =0;
     
     dfs(root,x,y,0);
        if(ParentX !=ParentY && levelX==levelY) {return true;}
             return false;
    
    }
        private void dfs(TreeNode node, int x, int y,int level){
            if(node.left!=null){
                     if(node.left.val==x){
                          ParentX=node;
                              levelX=level+1;
                     }
                            if(node.left.val==y){
                                   ParentY=node;
                                        levelY=level+1;
                     } 
                 dfs(node.left,x,y,level+1);
            }
            if(node.right!=null){
                     if(node.right.val==x){
                          ParentX=node;
                               levelX=level+1;
                          
                     }
                            if(node.right.val==y){
                                   ParentY=node;
                                  levelY=level+1;
                     }
                         dfs(node.right,x,y,level+1);
                 }
              
    }
}

//SOLUTION 2 -iTERATIVE
//  public boolean isCousins(TreeNode root, int x, int y) {
//         if(root ==null) return false;
//          Queue<TreeNode> queue = new LinkedList<>();
//           queue.add(root); 
//         int level =0;
//         TreeNode ParentX=null;
//         TreeNode ParentY=null;
//         int levelY=0,levelX=0;
        
//         while(!queue.isEmpty()){
//              int levelsize=queue.size();
           
//              for(int i=0;i<levelsize ;i++){
//                   TreeNode node = queue.poll();
//                  if(node.left!=null){
//                      if(node.left.val==x){
//                           ParentX=node;
//                               levelX=level+1;
//                      }
//                             if(node.left.val==y){
//                                    ParentY=node;
//                                         levelY=level+1;
//                      }
//                       queue.add(node.left);
//                  }
//                     if(node.right!=null){
//                      if(node.right.val==x){
//                           ParentX=node;
//                                levelX=level+1;
                          
//                      }
//                             if(node.right.val==y){
//                                    ParentY=node;
//                                   levelY=level+1;
//                      }
//                         queue.add(node.right);
//                  }
//              }
//             level++;
//     }
//         System.out.println("PARENTS "+ParentX +"---"+ParentY);
     
//          System.out.println("LEVELS: "+levelX+"----"+levelY);
        
//         if(ParentX !=ParentY && levelX==levelY) {return true;}
//         return false;
//     }

//SOLUTION 1
//        Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             TreeNode node= queue.poll();
//             System.out.println(node.val);
//             //Throws null pointer exception for left and right values. How to avoid this ?
//             if(node.left.val ==x && node.right.val ==y  || node.left.val ==y && node.right.val ==x){
//                 return false;
//             }
//             if(node.left!=null){
//                queue.add(node.left);  
//             }
//             if(node.right!=null){
//                  queue.add(node.right);
//             }
           
//         }
//         return true;