// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(h) => Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using DFS. Keep variable level and start dfs by visisting the right child. Check of level is equal to the size of resultant list, add to the result. After iterating over all the right nodes, interate over all the left nodes.
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        dfs(root, 0);

        return result;

    }

    private void dfs(TreeNode root, int level){

        if(root == null){
            return;
        }

        if(level == result.size()){
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}