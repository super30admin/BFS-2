/*
Time Complexity: O(N)
Space Complexity: O(H) where h is the height of the tree
DFS we are overwriting every time moving from left to right on each level
*/
class Solution {
    void helper(TreeNode current,int level, List<Integer> result){    
        /*initiaizing for the first time*/
        if(result.size()<=level){
        result.add(level,current.val);
        }
        /*replacing the second time*/
        else{
            result.set(level,current.val);
        }
        if(current.left!=null){
         helper(current.left,level+1,result);   
        }
        if(current.right!=null){
        helper(current.right,level+1,result);   
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        helper(root,0,result);
        return result;
    }
}