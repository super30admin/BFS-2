//Time Complexity : O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully
class Solution {
    //using dfs
    public void right(TreeNode root, int h, List<Integer> ans){
        if(root == null){
            return ;
        }
        if(h >= ans.size()){
            ans.add(root.val);
        }
        right(root.right, h+1, ans);
        right(root.left, h+1, ans);
        return ;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        right(root.right, 1, ans);
        right(root.left, 1, ans);
        return ans;
    }
}


//Using BFS
class Solution {
    //using dfs
    public void right(TreeNode root, int h, List<Integer> ans){
        if(root == null){
            return ;
        }
        if(h >= ans.size()){
            ans.add(root.val);
        }
        right(root.right, h+1, ans);
        right(root.left, h+1, ans);
        return ;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        right(root.right, 1, ans);
        right(root.left, 1, ans);
        return ans;
    }
}