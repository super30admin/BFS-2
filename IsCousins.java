public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        if(root.val == x || root.val == y)
            return false;
        boolean seen;
        int size;
        TreeNode temp;
        while(!bfs.isEmpty()){
            seen = false;
            size = bfs.size();

            for(int i=0;i<size;i++){
                temp = bfs.remove();
                if(temp.left!=null && temp.right!=null){
                    if((temp.left.val==x && temp.right.val == y) || (temp.left.val==y && temp.right.val == x))
                        return false;
                }

                if(temp.left!=null)
                    bfs.add(temp.left);
                if(temp.right!=null)
                    bfs.add(temp.right);

                if(temp.val == x || temp.val == y)
                    if(seen)
                        return true;
                    else
                        seen = true;
            }
            if(seen)
                return false;

        }
        return false;
    }
}
