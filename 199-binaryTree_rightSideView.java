//Approach-1: Using the BFS
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(! q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                
                //Right Side View
                if(i == size - 1){
                    res.add(node.val);
                }
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        
        return res;
    }
}


//Approach-2: Using the DFS
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(H) - Height of the recursion stack
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    public void dfs(TreeNode node, int level, List<Integer> res){
        //Base case
        if(node == null) return;
        
        //Functionality
        if(res.size() == level){
            res.add(node.val);
        }
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
        return;
    }
}


//Approach-3: Using the DFS - moving from left to right
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(H) - Height of the recursion stack
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    public void dfs(TreeNode node, int level, List<Integer> res){
        //Base case
        if(node == null) return;
        
        //Functionality
        if(res.size() == level){
            res.add(node.val);
        }else{
            res.set(level, node.val);
        }
        
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
        
        return;
    }
}