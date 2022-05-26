//time:O(n)
//space:O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> parnQ = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_is_found = false;
            boolean y_is_found = false;
            for(int i = 0;i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    x_is_found = true;
                }
                if(curr.val==y){
                    y_is_found = true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(x_is_found && y_is_found) return true;

        }
        return false;
    }
}
