//1.Binary Tree Right Side view
//Using BFS
//Time Complexity -> O(n)
//Space Complexity -> O(n/2) -> O(n) which is size of the queue
class Solution {
    //Using level order traversal of queue
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
        }
        return result;
    }

    

}

//Using DFS from right side view
//Time Complexity -> O(n)
//Space Complexity -> O(h)
class Solution {
    //Using right side DFS traversal first  
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if(root == null) return result;
        helper(root,0); 
        return result;       
    }

    private void helper(TreeNode root,int level){
        //base case
        if(root == null) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        helper(root.right,level+1); //calling right side of helper first
        helper(root.left,level+1); //after calling right we call left
    }
}

//Using DFS from left side
//Time Complexity -> O(n)
//Space Complexity -> O(h)
class Solution {
    //Using left side DFS traversal first  
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if(root == null) return result;
        helper(root,0);  //it means give me result starting from root which is at level 0
        return result;       
    }

    private void helper(TreeNode root,int level){
        //base case
        if(root == null) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level,root.val);
        }
        helper(root.left,level+1); //calling right side of helper first
        helper(root.right,level+1); //after calling right we call left
    }
}

//2. Cousins in a binary tree
//Using 2 queues
//Time Complexity -> O(n)
//Space Complexity -> O(2n)->O(n)
class Solution {
    //Using BFS and 2 queues
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;  
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> pq = new LinkedList();
        q.add(root);
        pq.add(null);
        while(!q.isEmpty()){
            boolean x_found = false;
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                TreeNode currP = pq.poll();
                if(curr.val == x){
                    x_found = true;
                    x_parent = currP;
                }
                if(curr.val == y){
                    y_found = true;
                    y_parent = currP;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if(x_found && y_found) {
               if(x_parent!=y_parent) {
                   return true;
               }else{
                   return false;
               }
            }
        }

        return false;
    }
}

//Using 1 queue 
//Time Complexity -> O(n)
//Space Complexity -> O(n)
class Solution {
    //Using BFS and 1 queue
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;  
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            boolean x_found = false;
            boolean y_found = false;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val ==x &&  curr.right.val == y) return false;
                     if(curr.left.val ==y && curr.right.val == x) return false;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }

        return false;
    }
}

//Using DFS
//Time Complexity -> O(n)
//Space Complexity -> O(h)
class Solution {
    //Using DFS
    TreeNode x_parent;
    TreeNode y_parent;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,0,x,y,null);
        return depth_x == depth_y && x_parent!=y_parent;
        
    }

    private void dfs(TreeNode root,int depth,int x,int y,TreeNode parent){
        //base case
        if(root == null) return;

        //logic
        if(root.val == x){
            depth_x= depth;
            x_parent = parent;
        }
        if(root.val == y){
            depth_y = depth;
            y_parent = parent;
        }
        dfs(root.left,depth+1,x,y,root);
        dfs(root.right,depth+1,x,y,root);
    }
}