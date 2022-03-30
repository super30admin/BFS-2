import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class RightSideView {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
		
	/**Approach: BFS level order traversal**/
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result= new ArrayList<>();		
		if(root==null) return result;
		
		//Add root node
		Queue<TreeNode> q= new LinkedList<>();
		q.add(root);
		
		//Process other nodes in level order
		int level=0;
		while(!q.isEmpty()) {
			int size= q.size();			
			for(int i=0; i<size; i++) {
				TreeNode curr= q.poll();				
				//Add the right most/last element from each level to the list
				if(i ==  size-1) {
					result.add(curr.val);
				}				
				if(curr.left!=null) q.add(curr.left);
				if(curr.right!=null) q.add(curr.right);
			}
			level++;
		}
        
        return result;
    }
    
	 // Driver code to test above 
	 public static void main(String args[]) {
		 RightSideView ob = new RightSideView();
		 TreeNode root= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));	 
		 
		 System.out.print("Right side view of given tree : "+ ob.rightSideView(root));		
    }
}
