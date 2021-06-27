// Time Complexity : O(N)
// Space Complexity : O(N) when height is full size of N
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
// Creating a List and adding the first value from the right side for each level

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {        
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);        
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(result.size() == level){ //when you reach a new level, you create a new array and add the right most possible value
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}