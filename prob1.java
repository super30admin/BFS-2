class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>arr = new ArrayList<>();
        function(0, arr, root);
        return arr;
    }
    public void function(int level, List<Integer>arr, TreeNode root){
        if(root == null) return;
        if(level == arr.size()) arr.add(root.val);
        else arr.set(level, root.val);
        function(level+1, arr, root.left);
        function(level+1 , arr, root.right);
    }
}