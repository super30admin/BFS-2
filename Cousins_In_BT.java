//Time complexity - O(n)
//Space Complexity - O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qp = new LinkedList<>();

        q.add(root);
        qp.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean xfound = false;
            boolean yfound = false;
            int parentx = 0;
            int parenty = 0;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode currParent = qp.poll();
                if(curr.val == x){
                    xfound = true;
                    parentx = currParent.val;
                }
                if(curr.val == y){
                    yfound = true;
                    parenty = currParent.val;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    qp.add(curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    qp.add(curr);
                }
            }

            if(xfound && yfound){
                if(parentx != parenty) return true;
            }
            if(xfound || xfound) return false;
        }
        return false;
    }
}
