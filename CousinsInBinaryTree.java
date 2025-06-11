//Time Complexity: O(n)
//Space Complexity: O(n) using parallel queues

//Using BFS - 1st Solution

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            TreeNode xParent = null;
            TreeNode yParent = null;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                TreeNode parentCurr = pq.poll();

                if(curr.val == x){
                    xFound = true;
                    xParent = parentCurr;
                }
                if(curr.val == y){
                    yFound = true;
                    yParent = parentCurr;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                 if(curr.right != null){
                    q.add(curr.right);
                    pq.add(curr);
                }

            }
            if(xFound && yFound){ //both nodes are at same level
                return xParent != yParent;
            }
            if(xFound || yFound) // one of them is at currLevel
                return false;
            
        }
        return false;  
    }
}


// 2nd Solution without having parallel queues

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
       
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
        
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                

                if(curr.val == x){
                    xFound = true;
                   
                }
                if(curr.val == y){
                    yFound = true;
            
                }
                if(curr.left != null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if(curr.left != null){
                    q.add(curr.left);
                   
                }
                 if(curr.right != null){
                    q.add(curr.right);
                   
                }

            }
            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
            
        }
        return false;
    }
}

//Using DFS Approach

class Solution {
    boolean result;
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, 0, null, x , y);
        return x_depth == y_depth && x_parent != y_parent;
    }

    private void helper(TreeNode root, int level, TreeNode parent, int x, int y){
        //base
        if(root == null)
            return;
        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }
        helper(root.left, level+1, root, x, y);
        helper(root.right, level+1, root, x, y);
    }
}

//Condition to reduce unnecessary recursive calls - DFS Approach

class Solution {
    boolean result;
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, 0, null, x , y);
        return x_depth == y_depth && x_parent != y_parent;
    }

    private void helper(TreeNode root, int level, TreeNode parent, int x, int y){
        //base
        if(root == null)
            return;

        if(x_parent != null && y_parent != null)
            return;
        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }
        helper(root.left, level+1, root, x, y);
        helper(root.right, level+1, root, x, y);
    }
}

//Eliminating need Parent parameter from recursion fucntion - 2nd DFS Approach

class Solution {
    boolean flag;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, 0, x , y);
        if(flag)
            return false;
        return x_depth == y_depth;
    }

    private void helper(TreeNode root, int level, int x, int y){
        //base
        if(root == null)
            return;
        if(flag)
            return;   
        //logic
        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y)
                flag = true;
            if(root.left.val == y && root.right.val == x)
                flag = true;
        }
        if(root.val == x){
            x_depth = level;
        }
        if(root.val == y){
            y_depth = level;
        }
        helper(root.left, level+1, x, y);
        helper(root.right, level+1, x, y);
    }
}

//Adding additional condition - DFS Approach

class Solution {
    boolean flag;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.flag = false;
        this.x_depth = -1;
        this.y_depth = -1;
        helper(root, 0, x , y);
        
        if(flag)
            return false;
        return x_depth == y_depth;
    }

    private void helper(TreeNode root, int level, int x, int y){
        //base
        if(root == null)
            return;
        if(flag)
            return;  
        if(x_depth != -1 && y_depth != -1)
            return; 
        //logic
        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y)
                flag = true;
            if(root.left.val == y && root.right.val == x)
                flag = true;
        }
        if(root.val == x){
            x_depth = level;
        }
        if(root.val == y){
            y_depth = level;
        }
        helper(root.left, level+1, x, y);
        helper(root.right, level+1, x, y);
    }
}