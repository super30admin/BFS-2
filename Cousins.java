//TC : O(n)
//sc : o(n)
//https://leetcode.com/problems/cousins-in-binary-tree/

//solution 1 with parents queue.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parent_q = new LinkedList<>();
        q.add(root);
        parent_q.add(null);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;
            for(int i = 0; i < size ; i++){
                TreeNode curr = q.poll();
                TreeNode pCurr = parent_q.poll();
                
                if(curr.val == x){
                    x_found = true;
                    x_parent = pCurr;
                }
                if(curr.val == y){
                    y_found = true;
                    y_parent = pCurr;
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                    parent_q.add(curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    parent_q.add(curr);
                } 
            }
            if(x_found && y_found){
                return x_parent != y_parent;
            }
            if(x_found || y_found) return false;
        }
        return false;
    }
}

// solution 2 without parents queue;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size ; i++){
                TreeNode curr = q.poll();
                
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                } 
            }
            if( x_found && y_found) return true;
        }
        return false;
    }
}
