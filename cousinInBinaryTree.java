// Time Complexity : O(N) 
// Space Complexity : O(1) but the stack height is equal to the height of the tree  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*
    1. Keep traversing the right side first and then the left side
    2. If the element is less than maxLevel add the element to the array and increase the maxLevel to current level
    3. This indicates the maxlevel's rightmost value has been added.
*/

// Your code here along with comments explaining your approach
class Solution {
    List<Integer> rightView = new ArrayList<Integer>();
    int maxLevel = 0;    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        dfs(root, 1);
        
        return rightView;
    }
    
    public void dfs(TreeNode root, int level) {
        if(root == null) return;
        if(level>maxLevel) {
            rightView.add(root.val);
            maxLevel = level;
        }
        
        if(root.right!=null) {
            dfs(root.right, level+1);
        }
        
        if(root.left != null) {
            dfs(root.left, level+1);
        }
    }
}
