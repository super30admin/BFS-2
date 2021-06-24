class Solution {
    // Time Complexity: O(n)
    // Space complexity: O(h)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode cur = root;
            for(int i = 0; i < size; i++){
                cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            // we should add val outside of for loop, then we will get
            // the last value of the queue, and the last val of the queue
            // also the last value on each level of the tree --> rightmost element
            res.add(cur.val);
        }
        
        return res;
    }
}