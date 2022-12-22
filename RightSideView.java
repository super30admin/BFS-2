import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

//Time Complexity : O(n) because traversing the whole tree
//Space Complexity :O(1) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class RightSideView {
	  public List<Integer> rightSideView(TreeNode root) {
	        
	         List<Integer> result = new ArrayList<>();
	        if(root==null)
	            return result;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	    
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            int i=0;
	            while(i<size){
	                TreeNode temp = queue.poll();
	                if(i==size-1){
	                    result.add(temp.val);
	                }
	                if(temp.left!=null)
	                    queue.add(temp.left);
	                 if(temp.right!=null)
	                    queue.add(temp.right);
	                
	                i++;
	            }
	        }
	        
	        return result;
	    }
	  
	   // To use DFS we should pass level at every recursion call. Maintain a list in the 
	   // global context,replace node values every time and for right view start from left recursion first 
	    
	  //Time Complexity : O(n) because traversing the whole tree
	  //Space Complexity :O(h) is the height for kids 
	  //Did this code successfully run on Leetcode :Yes
	  //Any problem you faced while coding this :

	  	List<Integer> result = new ArrayList<>();
	  	
	    public List<Integer> rightSideViewRecursive(TreeNode root) {
	        
	        if(root==null)
	            return result;
	       
	        helper(root,0);       
	        
	        return result;
	        
	    }
	        
	    public void helper(TreeNode root,int level){
	        // base
	        if(root==null)
	            return;
	        
	        // logic 
	        if(level==result.size()){
	            result.add(root.val);
	        }else{
	            result.set(level,root.val);
	        }
	        
	        helper(root.left,level+1);
	        helper(root.right,level+1);
	    }
	    
}
