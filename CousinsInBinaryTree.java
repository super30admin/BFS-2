class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(2n)
     // BFS Traversal     
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        q.add(root);
        parentQ.add(null);

        TreeNode xParent = null;
        TreeNode yParent = null;
        boolean xFound = false;
        boolean yFound = false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                TreeNode parent = parentQ.poll();
                if(curr.val == x){
                    xFound = true;
                    xParent = parent;
                }
                if(curr.val == y){
                    yFound = true;
                    yParent = parent;
                }

                if(curr.left != null){
                    q.add(curr.left);
                    parentQ.add(curr);
                }

                if(curr.right != null){
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }

            if(xFound && yFound) return xParent != yParent;
            if(xFound || yFound) return false;
        }
        return false;
        
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
     // BFS Traversal
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        boolean xFound = false;
        boolean yFound = false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left !=  null && curr.right != null){
                    if(curr.left.val == x && curr.right.val  == y) return false;
                    if(curr.left.val == y && curr.right.val  == x) return false;
                }

                if(curr.val == x){
                    xFound = true;
                }
                if(curr.val == y){
                    yFound = true;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return false;
        
    }


    // Time Complexity: O(n)
    // Space Complexity: O(h)
     // DFS Traversal     

    int xLevel;
    int yLevel;
    TreeNode xParent;
    TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        this.xLevel = -1;
        this.yLevel = -1;
        this.xParent = null;
        this.yParent = null;

        helper(root, x, y, 0, null);
        return xLevel == yLevel && xParent != yParent;

    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            xLevel = level;
            xParent = parent;
        }

        if(root.val == y){
            yLevel = level;
            yParent = parent;
        }

        if(xParent == null || yParent == null){
            helper(root.left, x,y, level+1, root);
            if(xParent == null || yParent == null)
                helper(root.right, x,y, level+1, root);
        }


    }
}