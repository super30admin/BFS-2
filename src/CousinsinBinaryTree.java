
/*
 * Time Complexity of the algorithm is O(n) where n is no. of nodes.
 * space Complexity will O(n) where n nodes will be in queue.
 */


public class CousinsinBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
    
	  TreeNode  x_parent,y_parent;
	  int x_height,y_height;  
	    
	     public boolean isCousins(TreeNode root, int x, int y) {
	         
	      if(root==null)
	          
	          return false;
	         
	        dfs(root,0,null,x,y); 
	         
	         return x_height==y_height && x_parent!=y_parent;
	         
	     }
	    
	    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
	        
	        //base
	        if(root==null)
	            return;
	        
	        
	        //logic
	        
	        if(root.val==x){
	            x_parent=parent;
	            x_height=level;
	        }
	        if(root.val==y){
	            y_parent=parent;
	            y_height=level;
	        }
	        
	        
	        dfs(root.left,level+1,root,x,y);
	        dfs(root.right,level+1,root,x,y);
	        
	    }
	    
	    
	    
	    
	    
//	     public boolean isCousins(TreeNode root, int x, int y) {
	         
//	         Queue<TreeNode> q= new LinkedList<>();
	        
//	         if(root==null)
//	             return false;
	        
//	         q.add(root);
	        
//	         while(!q.isEmpty()){
	            
//	             int size= q.size();
//	             boolean x_found =false, y_found= false;
//	             for(int i=0;i< size;i++){
	        
//	                 TreeNode curr= q.poll();
	                
	                
//	                 if(curr.val==x) x_found =true;
//	                 if(curr.val==y) y_found =true;
	                
//	                 if(curr.left!=null && curr.right!=null){
//	                     if(curr.left.val==x && curr.right.val==y)
//	                         return false;
//	                     if(curr.left.val==y && curr.right.val==x)
//	                         return false;
//	                 }
	                
//	                 if(curr.left!=null)
//	                     q.add(curr.left);
	                
//	                  if(curr.right!=null)
//	                     q.add(curr.right);
//	             }
	            
//	             if(x_found && y_found)
//	                 return true;
//	             if(x_found || y_found)
//	                 return false;
	            
//	         }
	      
//	         return false;
//	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CousinsinBinaryTree objIn = new CousinsinBinaryTree();

	}

}
