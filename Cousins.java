/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 time complexity : O(n)
 Space complexity : O(log(n))
 */
class Solution {
    List<List<Integer>> nums;
    int a;
    int b;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return true;
        nums = new ArrayList<>();
        a = x;
        b = y;
        getRes(root,0,-1);
        if(nums.size() != 2) return false;
        System.out.println(nums.get(0).get(1) +" "+ nums.get(1).get(1));
        if(nums.get(0).get(0) == nums.get(1).get(0) && nums.get(0).get(1) != nums.get(1).get(1)){
            return true;
        }
        return false;
    }
    private void getRes(TreeNode root, int level, int par){
        if(root == null || nums.size() == 2) return;
        
        if(root.val == a || root.val == b ){
            List<Integer> li = new ArrayList<>();
            li.add(level);
            li.add(par);
            nums.add(li);
        }
        getRes(root.left,level +1,root.val);
        getRes(root.right,level +1,root.val);
    }
}
