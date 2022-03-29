// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach



class Solution {
    List<Integer> result;
   public List<Integer> rightSideView(TreeNode root) {
       result = new ArrayList<>();
       if(root == null)    return result;
       dfs(root, 0);
       return result;
   }
   public void dfs(TreeNode root, int h){
       //Base case
       if(root == null)    return;
       
       if(result.size() == h){  // If we don't have any node value at specific height/ level just add the value for that height/ level.
           result.add(root.val);
       }
       
       //We will traverse right first, so it adds the right most value first and when we will traverse left, there will be already 1 value for each height
       //If we don't have, we will add the value for that index from left tree
       dfs(root.right, h + 1);
       dfs(root.left, h + 1);
   }
}

/*


class Solution {
     List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        //if(root == null)    return result;
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode root, int h){
        //Base case
        if(root == null)    return;
        
        if(result.size() == h){ // If we don't have any node value at specific height/ level just add the value for that height/ level.
            result.add(root.val);
        }else{
            result.set(h, root.val);// If there is value at specific height/ level just update the value with right-most/ current root value.
        }
        
        dfs(root.left, h + 1);
        
        dfs(root.right, h + 1);
       
    }
}

*/