/*
* Approach:
*  1. Apply BFS and insert the root.
        Maintain two variables for x_found and y_found as false
* 
*  2. Poll the elements in queue as node and 
        Compare node left and node right values with x and y.
        If they match update the x_found and y_found values and 
            add those children(left/right) to queue.
* 
*  3. Before adding them to queue, 
        if both x and y belong to same parent,
            return false -> belonging to same parent
        
        while traversing a level, if any one value is found,
            return false -> not in same level
        
        if both are found at same level, return true;
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    if found in last level
* 
* Space Complexity: O(w) === O(n)
    width of tree with max of n/2 leaf nodes.
* 
*/

import java.util.LinkedList;
import java.util.Queue;

public class IsCousinsBFS{
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            boolean found_x = false, found_y = false;

            for(int index = 0; index < size; index++){
                TreeNode curr = queue.poll();

                if(curr.left != null && curr.right != null){
                    // same parent for x and y
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    
                    if(curr.right.val == x && curr.left.val == y)
                        return false;
                }
                
                if(curr.val == x)
                    found_x = true;
                
                if(curr.val == y)
                    found_y = true;

                if(curr.left != null)
                    queue.add(curr.left);

                if(curr.right != null)
                    queue.add(curr.right);
            }

            if(found_x && found_y)
                return true;

            if(found_x || found_y)
                return false;
        }

        return false;
    }
}