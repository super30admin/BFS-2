//time - O(n)
//space - O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        TreeNode x_parent = null, y_parent = null;
        int size = 0;

        while(!q.isEmpty()){
            size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left!=null){
                    q.add(curr.left);
                    if(curr.left.val==x){
                        x_found=true;
                        x_parent=curr;
                    }
                    if(curr.left.val==y){
                        y_found=true;
                        y_parent=curr;
                    }
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    if(curr.right.val==x){
                        x_found=true;
                        x_parent=curr;
                    }
                    if(curr.right.val==y){
                        y_found=true;
                        y_parent=curr;
                    }
                }
            }
            if(x_found==true && y_found==true && x_parent!=y_parent) return true;
            if(x_found==true || y_found==true) return false;
        }

        return false;
    }
}
