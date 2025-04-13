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
class RightSideViewBT {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = myQueue.poll();
                if(i==size-1)
                    res.add(curr.val);
                if(curr.left != null)
                    myQueue.add(curr.left);
                if(curr.right != null)
                    myQueue.add(curr.right);
            }
        }
    return res;
    }
}