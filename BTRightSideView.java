// Approach 1: Using BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using BFS, we traverse the tree and keep track of level(depth)
// Since we are tracking level, we can add the last element at each level to result array

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                if(i==size-1)
                    result.add(temp.val);
            }
        }
        return result;
    }
}

// Approach 2: Using DFS
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using DFS, we traverse left side of tree and then right side
// At each level, we can overwrite elements if they already exist at a depth 

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root==null)
            return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth==result.size()){
            result.add(root.val);
        }
        else
            result.set(depth,root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);   
    }
}
