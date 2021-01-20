import java.util.*;
class ShowRightSideView {
	
	/*	
	Time complexity : O(N)
	Space complexity : Queue 
					 : O(N/2) = O(N) ~ N isS number of nodes
					 : At max all leaf nodes will be added in the queue 
					 
	Leetcode : YES
	Any problems : NO
	Approach : While doing BFS maintain size of each level, if current node is last node in the level add it to the output.
	*/
	 public List<Integer> rightSideView(TreeNode root) {
         List<Integer> output = new ArrayList<Integer>();
        if(root == null) return output;
       
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i = 0 ;i < size ;i++){
                TreeNode curr = que.poll();
                if(i == size -1){
                    output.add(curr.val);
                }

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }          
        } 
        return output;
    }
}