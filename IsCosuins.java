import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class IsCosuins {
	 
	//Time Complexity : O(n) because traversing the whole tree
		//Space Complexity :O(h) for storing stack memory space 
		//Did this code successfully run on Leetcode :Yes
		//Any problem you faced while coding this :
		 
		 private TreeNode parentX;
		    private TreeNode parentY;
		    private int levelX;
		    private int levelY;
		    private boolean found = true;
		    
		    public boolean isCousinsRecursive(TreeNode root, int x, int y) {
		       
		        helper(root,null,0,x,y);
		        return parentX != parentY && (levelX==levelY);
		    }
		    
		    public void helper(TreeNode root,TreeNode parent,int level, int x, int y){
		        
		        // base case 
		        if(root ==null)
		            return;
		        
		        // logic case
		        if(root.val==x){
		            levelX = level;
		            parentX = parent;
		        }
		         if(root.val==y){
		            levelY = level;
		            parentY = parent;
		        }
		        helper(root.left,root,level+1,x,y);
		        helper(root.right,root,level+1,x,y);
		        
		    }
	

		  //Time Complexity : O(n) because traversing the whole tree
		  //Space Complexity :O(n) for storing parents 
		  //Did this code successfully run on Leetcode :Yes
		  //Any problem you faced while coding this :
		    
	public boolean isCousins(TreeNode root, int x, int y) {
	        if(root==null)
	            return false;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        Map<TreeNode,TreeNode> parents = new HashMap<>();
	        queue.add(root);
	        parents.put(root,null);
	        while(!queue.isEmpty()){
	            int size = queue.size();
	           
	            boolean found1 = false;
	            boolean found2 = false;
	            TreeNode parent1 = null;
	             TreeNode parent2 = null;
	            for(int i=0;i<size;i++){
	                TreeNode temp = queue.poll();
	                
	                if(!found1 && temp.val==x){
	                    found1 = true;
	                    parent1 = parents.get(temp);
	                }
	                
	                if(!found2 && temp.val==y){
	                    found2 = true;
	                    parent2 = parents.get(temp);
	                }
	                
	                if(found1 && found2 && parent1!=parent2){
	                        return true;
	                }
	                
	                if(temp.left!=null){
	                  queue.add(temp.left);  
	                  parents.put(temp.left, temp);
	                }
	                    
	                 if(temp.right!=null){
	                    queue.add(temp.right);
	                     parents.put(temp.right, temp);
	                 }
	                   
	            }
	            
	        }  
	         return false;
	    }
	 
	
	 
}
