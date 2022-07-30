
//Recursive Approach

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
    
    int xLev=-1;
    int yLev=-1;
    TreeNode xPar=null;
    TreeNode yPar=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
        if(xLev>-1 && yLev>-1 && xLev==yLev && xPar!=yPar) return true;
        return false;
    }
    
    private void helper(TreeNode root, int x, int y,int l,TreeNode parent){
   
        //Base
        if(root==null) return;
        //Logic
        if(root.val==x){
            xPar=parent;
            xLev=l;
        }
        if(root.val==y){
            yPar=parent;
            yLev=l;
        }
        
        if(xPar==null || yPar==null){
            helper(root.left,x,y,l+1,root);
            helper(root.right,x,y,l+1,root);
        }
    }
}


//Itterative approach

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
    public boolean isCousins(TreeNode root, int x, int y) {
        return helper(root,x,y,0);
    }
    
    private boolean helper(TreeNode root, int x, int y,int l){
        if(root==null) return false;
        //List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        TreeNode xP=null,yP=null;
        int xL=-1,yL=-1;
        
        while(!q.isEmpty()){

            int size =q.size();
            //list.clear();
            
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                //list.add(temp.val);
                
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);                    
                } 
                
                if(temp.left!=null){
                    if(temp.left.val==x){
                        xP=temp;
                        xL=l+1;
                    }
                    else if(temp.left.val==y){
                        yP=temp;
                        yL=l+1;
                    }
                }
                if(temp.right!=null){
                    if(temp.right.val==x){
                        xP=temp;
                        xL=l+1;
                    }
                    else if(temp.right.val==y){
                        yP=temp;
                         yL=l+1;
                    }
                }
                
            }
            l++;
           


        }
        if(xL>-1 && yL>-1 && xL==yL && xP!=yP) return true;
        return false;
    }
}