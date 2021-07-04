// Time Complexity : O(n)
// Space Complexity : O(1) , it is constant because even though I use a hashmap, it stores at max 4 values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much.


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer,Integer> parents=new HashMap<>();
    HashMap<Integer,Integer> depths=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        helper(root.left,root,x,y,1);
        helper(root.right,root,x,y,1);
        
        return parents.get(x)!=parents.get(y) && depths.get(x)==depths.get(y);
    }
    
    public void helper(TreeNode traverse, TreeNode parent, int x, int y, int depth)
    {
        if(traverse==null)
            return;
        
        if(traverse.val==x || traverse.val==y)
        {    
            parents.put(traverse.val,parent.val);       
            depths.put(traverse.val,depth);
        }   
        if(traverse.left!=null)
            helper(traverse.left,traverse,x,y,depth+1);
        
        if(traverse.right!=null)
            helper(traverse.right,traverse,x,y,depth+1);
    }
}