/**
Time complexity: O(n)
Space complexity: O(n)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/
class Solution {
    /**
    Approach:
    - This is a BFS solution
    - Create a queue and the root node to it.
    - Maintain a size variable to keep track of the level.
    - Add the current node's left and right to the queue.
    - But add only the right node's value into the result list
    */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = null;
            for(int i=0; i<size; i++) {
                curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(curr.val);
        }
        return result;
    }
}
