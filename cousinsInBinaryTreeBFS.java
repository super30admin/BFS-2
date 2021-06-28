// Time Complexity: O(n) where n is the number of nodes.
// Space Complexity: O(n) as Queue is going to occupy the maximum space in worst case by holding n/2 elements.
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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> target = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(target.size() >= 1) break;        // break if in previous iteration of level we found only one element
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                    if(curr.left.val == x || curr.left.val == y){
                        target.add(curr);
                        height.add(depth);
                    }
                }
                if(curr.right != null){
                    q.add(curr.right);
                    if(curr.right.val == x || curr.right.val == y){
                        target.add(curr);
                        height.add(depth);
                    }
                }
            }
            depth++;
        }
        // Confirm if we found both element and they adhere to all given conditions
        if(target.size() == 2 && target.get(0) != target.get(1) && height.get(0) == height.get(1)) return true;
        return false;
    }
}