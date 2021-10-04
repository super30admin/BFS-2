class CousinsInBinaryTree {

    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)

    public boolean isCousins(TreeNode root, int x, int y) {
        // Edge Case Checking
        if(root == null)
            return false;
        
        int levelX = 0, levelY = 0, level = 0;
        TreeNode parentX = null, parentY = null;
        boolean gotX = false, gotY = false;
        
        // Initializing Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // Do a BFS and when we find x and y - we keep track of their respective parent nodes and their levels
        while(!q.isEmpty()){
            // Optimization - if we found x and y - then don't search the remaining tree
            if(gotX && gotY)
                break;
            int size = q.size();
            level++;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null){
                    if(curr.left.val == x){
                        parentX = curr;
                        levelX = level + 1;
                        gotX = true;
                    }else if(curr.left.val == y){
                        parentY = curr;
                        levelY = level + 1;
                        gotY = true;
                    }
                    q.offer(curr.left);
                }
                
                if(curr.right != null){
                    if(curr.right.val == x){
                        parentX = curr;
                        levelX = level + 1;
                        gotX = true;
                    }else if(curr.right.val == y){
                        parentY = curr;
                        levelY = level + 1;
                        gotY = true;
                    }
                    q.offer(curr.right);
                }
            }
        }
        
        // If the depth of x and y is same and parents are different - then true else false
        return parentX != parentY && levelX == levelY;
    }
}