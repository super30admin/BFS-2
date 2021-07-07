
//BFS
// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(B) where B is the breath of the tree
// This solution worked on LeetCode

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)    return false;
        Queue<TreeNode> q = new LinkedList<>();   
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xfound = false;
            boolean yfound = false;
            for(int i=0;i < size;i++){
                TreeNode node = q.poll();
                if(node.val == x)   xfound= true;
                if(node.val == y)   yfound= true;
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y)   return false;
                    if(node.left.val == y && node.right.val == x)   return false;
                }
                if(node.left != null)   q.add(node.left);
                if(node.right != null)   q.add(node.right); 
            }
            if(xfound && yfound)    
                return true;
        }
        return false;  
    }
}
