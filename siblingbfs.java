class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
       if(root == null || root.val == x ||root.val == y)
           return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xfound =false,yfound=false;
        while(!queue.isEmpty())
        {
            int sz = queue.size();
            
            for(int i=0;i<sz;i++)
            {
                TreeNode curr = queue.poll();
                if(curr.val == x) xfound =true;
                if(curr.val == y) yfound = true;
                
                if(curr.right!=null && curr.left!=null)
                {
                int a=curr.right.val;
                int b =curr.left.val;
                if((a ==x && b==y)||(a==y && b==x)) return false;
                }
                
                
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            if(xfound == true && yfound == true) return true;
            if(xfound || yfound) return false;
        }
        return false;
    }
}