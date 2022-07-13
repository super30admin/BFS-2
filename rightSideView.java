// Time Complexity: O(n)
//Space Complexity: O(logn)
import java.util.*;
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result,0);
        return result;
    }
 
    public void dfs(TreeNode root,List result,int depth){
        if(root==null) return;
        if(depth==result.size())
            result.add(root.val);
        dfs(root.right,result,depth+1);
        dfs (root.left,result,depth+1);
 
    }
 
 }