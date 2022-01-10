import java.util.*;

public class Cousins {

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
	
	 public boolean isCousins(TreeNode root, int x, int y) {
	        
	        Queue <TreeNode> q= new LinkedList<>();
	        boolean c1=false;
	        boolean c2=false;
	        
	        q.add(root);
	        
	        while(!q.isEmpty())
	        {
	            
	             c1=false;
	             c2=false;
	            int size=q.size();
	         
	            for( int i=0;i<size;i++){
	          
	                TreeNode out=q.poll();
	            
	            if(out.left!=null&&out.right!=null){
	                
	                if(out.left.val==x&&out.right.val==y||out.left.val==y&&out.right.val==x){
	                
	                
	                return false;}
	            }
	                
	                
	          if(out.val==x){ c1=true;}
	          if(out.val==y){c2=true;}      
	                
	                if(out.left!=null){
	                q.add(out.left);
	            }
	            
	            if(out.right!=null){
	                
	                q.add(out.right);
	            }
	                
	            
	            

	            
	         }
	            if(c1==true&&c2==true){return true;}
	            
	          
	            
	           
	        }
	        return false; 
	            
	    
	    }
	
	
}

