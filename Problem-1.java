/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Cousins in a binary tree
//TC:O(N)
//SC:O(N)

class Pair
{
   
   TreeNode node;
   TreeNode parent;
    
    public Pair(TreeNode node,TreeNode parent)
    {
        this.node = node;
        this.parent=parent;
        
    }
}


class Solution {

    
        int l_x=-1;
        int l_y=-1;
        TreeNode p_x = null;
        TreeNode p_y = null;
  
    public boolean isCousins(TreeNode root, int x, int y)
    {
      
       if(root==null) return false;
       
        bfs(root,null,x,y,0);
      
      if(l_x==l_y && p_x!=p_y) return true;
        
        return false;
        
    }
    
    public  void bfs(TreeNode root,TreeNode parent,int x,int y,int level)
    {
           Queue<Pair> q = new LinkedList<>();
           Pair t = new Pair(root,parent);
          // System.out.println(t.node.val);
           //System.out.println(t.parent);
           q.add(t);
        
          // System.out.println(q);
           while(!q.isEmpty())
           {
            int size=q.size();
           
            for(int i=0;i<size;i++)
            {
              Pair m = q.poll();
                //System.out.println(m.node);
              if(m.node.val == x){
                 l_x = level;
                 p_x = m.parent;
              }
                
              if(m.node.val == y){
                 l_y = level;
                 p_y = m.parent;
              }
              if(m.node.left!=null) q.add(new Pair(m.node.left,m.node));
              if(m.node.right!=null) q.add(new Pair(m.node.right,m.node));   
            }
                level=level+1;
            }
         }    
            
        
    
    
    
    
    
    
    
    
 