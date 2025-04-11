// TC: O(N)
// SC: O(N/2)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                System.out.println("size" + size);
                TreeNode curr = q.poll();
                System.out.println("curr" + curr);
                // Take out right node and add to queue
                if(i==size-1) {
                    result.add(curr.val);
                }
                // Add left and right children of the node taken out from the queue.
                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
            return result;      
    }
}