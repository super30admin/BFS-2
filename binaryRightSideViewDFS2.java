//dfs solution where we traverse root left right
// only difference to prev logic is dfs traversal is suck that it makes us possible to replace the position of already visited lvl element to 
// most recent visited element!
// TC O(N) SC O(H)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int lvl) {
        //base
        if(root == null) {
            return;
        }
        //logic
        if(lvl == result.size()) {
            result.add(root.val);
        }
        else {
            result.set(lvl, root.val);
        }
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}