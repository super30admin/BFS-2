//Accepted on LT
//Do right Dfs and at every new height just add elemet to list
//O(h) should be time and space
class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null) return l;
        l.add(root.val);
        helper(root,1);
        return l;
    }
    public void helper(TreeNode root,int h){
        //base
        if(root==null) return;
        if(h>l.size()){
            l.add(root.val);
        }
        //logic
        helper(root.right,h+1);
        helper(root.left,h+1);
    }
}