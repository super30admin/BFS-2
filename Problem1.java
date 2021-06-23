
// Time - O(N)
// Space - O(N)


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // iterate through the queue not empty
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                // remove first node from the queue
                TreeNode node = q.poll();

                // add the last child in the level to the result list
                if(i == size - 1) {
                    result.add(node.val);
                }

                // iterate through left and right child and add to the queue
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }



        }

        return result;

    }
}