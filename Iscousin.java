class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            List<Integer> list = new ArrayList<>();
            while(cnt-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y ){
                        return false;
                    }
                    if(cur.left.val == y && cur.right.val == x ){
                        return false;
                    }
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            if(list.contains(x) && list.contains(y)){
                return true;
            }
        }
        return false;
    }
}