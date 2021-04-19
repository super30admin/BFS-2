// Time Complexity : O(n) where n is total nodes in the tree
// Space Complexity : O(n) where n is total nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Deque<TreeNode> q = new ArrayDeque();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xf = false, yf= false;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.val == x) xf=true;
                if(node.val == y) yf=true;
                if(node.left != null && node.right!=null){
                    if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) return false;
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            if(xf && yf) return true;
        }
        return false;
    }
}