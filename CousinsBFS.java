// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        if(x == y){
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null){
                    if(current.left.val == x){
                        xParent = current;
                        xFound = true;
                    }
                    if(current.left.val == y){
                        yParent = current;
                        yFound = true;
                    }
                    
                    queue.add(current.left);
                }
                if(current.right != null){
                    if(current.right.val == x){
                        xParent = current;
                        xFound = true;
                    }
                    if(current.right.val == y){
                        yParent = current;
                        yFound = true;
                    }
                    queue.add(current.right);
                }
            }
            
            if(xFound && yFound){
                if(xParent != yParent){
                    return true;
                }else{
                    return false;
                }                
            }
            
            if(xFound || yFound){
                return false;
            }
        }
        return false;        
    }
}