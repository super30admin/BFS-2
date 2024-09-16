class Solution {//Time and space of O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        //Base case
        if(root == null)
            return false;
        queue.offer(root);
        int size;
        while(!queue.isEmpty()){
            size = queue.size();
            boolean is_x_found = false;
            boolean is_y_found = false;
            for(int i =0; i<size ; i++){
                TreeNode temp = queue.poll();
                if(temp.val == x) is_x_found= true;
                if(temp.val == y) is_y_found= true;
                //If node has x and y child, are x and y happen to be siblings of this node
                if(temp.left != null && temp.right != null){
                    if((temp.left.val == x && temp.right.val == y)||(temp.left.val == y && temp.right.val == x))
                        return false;
                }
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            if(is_x_found && is_y_found) return true;
        }
        return false;
    }
}