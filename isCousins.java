// Time Complexity :O(N)
// Space Complexity :(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int qsize = queue.size();
            int flag = 0;
            for(int i=0 ;i<qsize;i++){
                TreeNode node =queue.poll();
                if(node.right != null && node.left != null){
                    if((node.left.val == x || node.left.val == y) && 
                        (node.right.val == x || node.right.val==y)){
                            return false;
                    }
                }
                if(node.left != null) {
                    if(node.left.val == x || node.left.val == y){
                        flag++;
                    }
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x || node.right.val == y){
                        flag++;
                    }
                    queue.offer(node.right);
                }
                    
            } 
            if(flag == 2){
                return true;
            }else if(flag == 1){
                return false;
            }
        }
        return false;
    }
        
}
