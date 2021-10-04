class BinaryTreeRightSideView {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Edge Case Checking
        if(root == null)
            return result;
        
        // Initializing queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode curr = null;
            for(int i = 0; i < size; i++){
                curr = q.poll();
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }
            
            // whenever we move ahead to the next level of tree - the last value of 'curr' would be the rightmost element of the current level -> therefore add it to the output list
            result.add(curr.val);
        }
        
        return result;
    }
}