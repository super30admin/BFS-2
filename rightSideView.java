// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);

        while (!queue.isEmpty()) {
            
            int size = queue.size();
           
            for (int i = 0; i < size; i++) {

                
                TreeNode cur = queue.poll();
                
                // Add last node from current queue size to ans list
                if(i==size-1) ans.add(cur.val);
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    return ans;
    }
}
