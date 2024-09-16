/**
Daily Problem #59
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    I had trouble thinking of a way to keep track of the parents,
    but once I figured it out it was straight forward
 */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            // Key: child | value: parent
            Map<Integer, Integer> childParentMap = new HashMap<>();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(current.left != null){
                    q.add(current.left);
                    childParentMap.put(current.left.val, current.val);  
                } 
                if(current.right != null){
                    q.add(current.right);
                    childParentMap.put(current.right.val, current.val);
                } 
            }
            // if both x and y are found in map, they are at the same depth
            if(childParentMap.containsKey(x) && childParentMap.containsKey(y)){
                // check if x and y have different parents
                return childParentMap.get(x) != childParentMap.get(y);
            }
        }

        return false;
    }
}