

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
class Problem1 {
    private List<Integer> al;
    public List<Integer> rightSideView(TreeNode root) {
        al= new ArrayList<>();
        if(root == null) return al;
        Queue<TreeNode> q= new  LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s= q.size();
            for(int i=0;i<s;i++){
                TreeNode curr= q.poll();
                if(i==s-1){

                    al.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
        }
        return al;
    }
}

// Time Complexity: O(N) where N is the number of nodes in the binary tree. We visit each node exactly once.
// Space Complexity: O(W) where W is the maximum width of the binary tree. This is the maximum number of nodes at any level in the tree, which is the maximum size of the queue at any point in time.

