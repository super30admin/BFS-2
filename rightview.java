// Time Complexity : O(n) n no.of nodes
// Space Complexity : O(l) l no.of levels
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
Used level order traversal and stored added the last element of each level to the result list and returned the result list



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
 */
class Solution {
    List<Integer> result = new ArrayList<>();
   HashMap<Integer,List<Integer>>map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        int level = 0;
        while(map.containsKey(level)){
            List<Integer>li = map.get(level);
            result.add(li.get(li.size()-1));
            level++;
        }
        return result;
    }
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        
        //logic
        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>());
        }
        map.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
    
}