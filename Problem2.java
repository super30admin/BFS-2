//Problem-1
//993. Cousins in Binary Tree

//TC = O(n) where n is total number of nodes
//SC = O(b) where d is breadth of tree

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean foundx = false;
            boolean foundy = false;
            for(int i = 0; i < size; i++){
                TreeNode a = q.poll();
                if(a.val == x){
                    foundx = true;
                }
                else if(a.val == y){
                    foundy = true;
                }
                if(foundx && foundy) return true;
                if((a.left != null && a.right != null) && ((a.left.val == x && a.right.val == y) || (a.left.val == y && a.right.val == x))){
                    return false;
                }
                else{
                    if(a.left != null){
                        q.add(a.left);
                    }
                    if(a.right != null){
                        q.add(a.right);
                    }
                }
            }
            if(foundx || foundy) return false;
            
        }
        return false;
    }
}
