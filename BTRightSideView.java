//Time Complexity :O(n)
//Space Complexity :O(n)
// leetcode : success
class Solution {
     
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        
        helper(root,0,list);
        
        return list;
    }
    
    private void helper(TreeNode root , int level , List<Integer> list){
        if(level == list.size()){
            list.add(root.val);
        }
        
        if(root.right != null){
            helper(root.right , level +1 , list);
        }
        if(root.left != null){
            helper(root.left , level +1 , list);
        }
            
    }
}