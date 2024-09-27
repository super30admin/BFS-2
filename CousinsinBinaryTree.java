class CousinsinBinaryTree { 
    // Approach 1 - using recursion
    // Time complexity O(n)
    // Space complexity O(n)
    // Tested in leetcode
    
    // Initialize hashmaps to store node parents and its depth information
    HashMap<Integer,Integer> depth = new HashMap<>();
    HashMap<Integer,Integer> parent = new HashMap<>();
    
    // Driver function for approach 1.
    // This function will check into nodes value into depth and parent information
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        helper(root,null);
        if(depth.get(x) == depth.get(y) && parent.get(x) == parent.get(y))
            return true;
        return false;
    }
    
    // Helper function for approach1. This function will call recursively itself
    // and for itetaion node parent and its level is set to corresponding hashmap
    public void helper(TreeNode root, TreeNode parent){
        if(root == null)
            return;
        depth.put(node.val,par != null ? 1+depth.get(par.val) : 0);
        parent.put(node.val,par);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    // Approach 2 - Iterative approach
    // Time complexity O(n)
    // Space complexity O(n)
    // Tested in leetcode
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        // queue to hold nodes level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // loop will execute till queue is empty 
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean a = false, b = false;
            
            // will run for each level one by one
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == x)
                    a = true;
                if(node.val == y)
                    b = true;
                    
                // If childrens of a node contains the target value return false;
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y || node.left.val == y && node.right.val == x)
                        return false;
                }
                
                // add children to the queue
                if(node.left != null)
                    queue.offer(node.left);
                    if(node.right != null)
                    queue.offer(node.right);
            }
            if(a && b)
                return true;
        }
        return false;
        }
    }