// Time - 0(n)
// Space - O(n)

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
    HashMap<Integer, List<TreeNode>> hm = new HashMap<>();
    int maxdepth = Integer.MIN_VALUE;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        helper(root,0);
        for(int i=0;i<=maxdepth;i++){
            List<TreeNode>li = hm.get(i);
            TreeNode n = li.get(li.size()-1);
            res.add(n.val);
        }
        return res;
        
        
    }

    public void helper(TreeNode root, int depth){
        if(root==null){
            return;
        }
        maxdepth = Math.max(maxdepth, depth);
        if(hm.containsKey(depth)){
            List<TreeNode>li = hm.get(depth);
            li.add(root);
            hm.put(depth,li);
        }
        else{
            List<TreeNode>li = new ArrayList<>();
            li.add(root);
            hm.put(depth,li);
        }
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }
}

