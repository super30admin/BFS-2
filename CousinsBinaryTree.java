/*
Desc : We do a level order traversal while we also check for every nodes' children for being present in same level,
a check for the same parent case is also made at every iteration.
Time Complexity : O(n)
Space Complexity : O(1)
*/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root.val == x || root.val == y) return false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found=false; boolean y_found=false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val==x) x_found=true;
                if(curr.val==y) y_found=true;
                if(curr.left!=null && curr.right!=null)
                    if((curr.left.val==x)&&(curr.right.val==y)||(curr.right.val==x)&&(curr.left.val==y)) return false;
                
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
}
