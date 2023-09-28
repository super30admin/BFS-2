// Time Complexity : O(n) traverses through all nodes of tree
// Space Complexity : O(h) recursive stack space for recursive dfs calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {

    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        rightView = new ArrayList<>();
        dfs(root, 0);

        return rightView;
    }

    private void dfs(TreeNode root, int lvl){
        if(root == null){
            return;
        }
        if(rightView.size() <= lvl){
            rightView.add(root.val);
        }
        dfs(root.right, lvl + 1);
        dfs(root.left, lvl + 1);
    }
}
