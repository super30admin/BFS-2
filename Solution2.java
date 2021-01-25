package second;
//Space Complexity:O(N)
//Time Complexity:O(N)
public class Solution2 {
	  public boolean isCousins(TreeNode root, int x, int y) {
	        Queue<TreeNode> que = new LinkedList<>();
	        que.add(root);
	        while(!que.isEmpty()){
	            boolean x_found = false;
	            boolean y_found = false;
	            int size = que.size();
	            for(int i=0;i<size;i++){
	                TreeNode curr = que.poll();
	                if(curr.val == x)x_found =true;
	                if(curr.val == y)y_found = true;
	                if(curr.left!=null && curr.right!=null){
	                    if(curr.left.val == x && curr.right.val == y)return false;
	                    if(curr.left.val == y && curr.right.val == x)return false;
	                }
	                if(curr.left!=null)que.add(curr.left);
	                if(curr.right!=null)que.add(curr.right);
	            }
	            if(x_found && y_found)return true;
	            if(x_found || y_found)return false;
	        }return false;
	    }
}
