// dfs solution 
// we got root right left -> inroder traversal
// logic is if result array size equals level we add the element to the result!
//SC O(H) -> height of the tree  TC: O(N) 
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
        dfs(root.right, lvl + 1);
        dfs(root.left, lvl + 1);
    }
}