// # BFS-2

// ## Problem 1

// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(i==size - 1){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
            return result;
        }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
        }
        private void dfs(TreeNode root, int level){
            if(root == null) return;
            if(level == result.size()){
                result.add(root.val);
            }
            
            dfs(root.right, level+1);
            dfs(root.left, level+1);
        }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
        }
        private void dfs(TreeNode root, int level){
            if(root == null) return;
            if(level == result.size()){
                result.add(root.val);
            }else{
                result.set(level, root.val);
            }
            
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }
}

// ## Problem 2

// Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    TreeNode parent_x;
    TreeNode parent_y;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return parent_x != parent_y && depth_x == depth_y;
    }
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth){
        if(root == null) return;

        if(root.val == x){
            parent_x = parent;
            depth_x = depth;
        }
        if(root.val == y){
            parent_y = parent;
            depth_y = depth;
        }
        dfs(root.left, root, x, y, depth+1);
        dfs(root.right, root, x, y, depth+1);

    }
}