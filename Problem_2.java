/*

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

TC : O(n)
SC : O(n)
Leet Code : Yes

 */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null){
            return false;
        }
        
        boolean x_found = false;
        boolean y_found = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            if(x_found && y_found){
                return true;
            }
            if(x_found || y_found){
                return false;
            }
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();

                if(node.left != null && node.right != null){
                     if((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y)){
                    return false;
                    }
                }
            
                if(node.left != null){
                    if(node.left.val == x){
                        x_found = true;
                    }
                    if(node.left.val == y){
                        y_found = true;
                    }
                    q.add(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x){
                        x_found = true;
                    }
                    if(node.right.val == y){
                        y_found = true;
                    }
                    q.add(node.right);
                }
            }          

        }

        return false;


    }
}