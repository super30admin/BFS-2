class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xf = false;
            boolean yf = false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xf =true;
                if(curr.val == y) yf =true;

                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(xf && yf) return true;
            if(xf || yf) return false;
        }
        return false;
    }
}
