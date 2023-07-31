// Time Complexity : O(n)
// Space Complexity : O(h) optimal DFS
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Solution 1 (Binary tree right side view): using DFS
// Time: O(n) Space: O(h) for stack
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int level){
        if(root == null) return;

        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, result, level+1);
        dfs(root.left, result, level+1);
    }
}

// Solution 2: using BFS
// Time : O(n) Space: O(2^h) =O(n/2) = O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
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