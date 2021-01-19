

import java.util.*;

class CheckisCousins{
	
	

/*
	Time complexity : O(N)
	Space complexity : Queue + HashMap
					 : O(N/2) + O(N) = O(N) ~ N is number of nodes
					 : At max all leaf nodes will be added in the queue + all nodes in HashMap
					 
	Leetcode : YES
	Any problems : NO
*/

public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Integer,Integer> map = new HashMap<>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            HashSet<Integer> currLevelSet = new HashSet<>();
            
            TreeNode curr = queue.peek();
            for(int i = 0; i < size; i++){
                curr = queue.poll();
                
                currLevelSet.add(curr.val);            
                
                if(curr.left != null){
                    queue.add(curr.left);
                    map.put(curr.left.val, curr.val);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                    map.put(curr.right.val, curr.val);
                    
                }
            }
            
            if(currLevelSet.contains(x) && currLevelSet.contains(y)){
                if(map.get(x) != map.get(y)){
                    return true;
                }
            }
                  
        }
        
        
         return false;
    }
}