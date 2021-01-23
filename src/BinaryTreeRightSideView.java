import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.util.customlist.TreeNode;

public class BinaryTreeRightSideView {
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using DFS method where the recursive stack is run under the hood.
	 * Here, when the in-order traversal is happening from the right, the result arraylist will get populated when the size of the arraylist is equal to the height of the current node present.
	 */
	//DFS moving from right
    List<Integer> result;
    public List<Integer> rightSideViewDFSFromRight(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        dfs1(root, 0);
        return result;
    }
    
    private void dfs1(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(root.val);
        }
        
        dfs1(root.right, level + 1);
        dfs1(root.left, level + 1);
    }
    
    // Time Complexity : O(n)
 	// Space Complexity : O(1)
 	// Did this code successfully run on Leetcode : yes
 	// Any problem you faced while coding this : No
 	// Your code here along with comments explaining your approach
 	/*
 	 * This approach is by using DFS method where the recursive stack is run under the hood.
 	 * Here, when the in-order traversal is happening from the left, the result arraylist will get replaced when the node value is present 
 	 * in the index of the arraylist when it is equal to the height of the current node present.
 	 */
    
    //DFS moving from left
    List<Integer> result1;
    public List<Integer> rightSideViewDFSFromLeft(TreeNode root) {
        result1 = new ArrayList<>();
        if(root == null)return result1;
        dfs2(root, 0);
        return result1;
    }
    
    private void dfs2(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(level == result1.size()){
            result1.add(root.val);
        }else{
            result1.set(level,root.val);
        }
        dfs2(root.left, level + 1);
        dfs2(root.right, level + 1);
    }
    
    // Time Complexity : O(n)
  	// Space Complexity : O(1)
  	// Did this code successfully run on Leetcode : yes
  	// Any problem you faced while coding this : No
  	// Your code here along with comments explaining your approach
  	/*
  	 * This approach is by using BFS method where each level when traversed will push all the nodes present in that level.
  	 * Here, when all the nodes present in that level are pushed, we will only note the last element of the queue in the array list, since we 
  	 * want only the right side viewed nodes of the tree.
  	 */
    
    //BFS
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
    
}
