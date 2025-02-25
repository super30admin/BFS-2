class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue= new LinkedList<>();
        Queue<TreeNode> pqueue= new LinkedList<>();
        queue.add(root);
        pqueue.add(null);
        while(!queue.isEmpty()){
            int size= queue.size();
            boolean  x_found = false;
            boolean y_found =false;
            TreeNode x_parent =null;
            TreeNode y_parent= null;
            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();
                TreeNode curr1= pqueue.poll();
                if(curr.val == x){
                    x_found = true;
                    x_parent = curr1;
                }
                if(curr.val == y){
                    y_found = true;
                    y_parent = curr1;

                }
                if(curr.left!=null ){
                    queue.add(curr.left);
                    pqueue.add(curr);
                }
                if(curr.right!=null ){
                    queue.add(curr.right);
                    pqueue.add(curr);
                }


            }
            if(x_found  && y_found ) return x_parent !=y_parent;
            if(x_found  || y_found ) return false;
        }
        return false;
    }
}