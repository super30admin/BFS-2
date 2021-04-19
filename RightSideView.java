// Time Complexity : O(n) where n is the total number of nodes 
// Space Complexity : O(n)where n is the total number of nodes (for a skewered tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> ret = new ArrayList();
        while(!q.isEmpty()){
            int size =q.size();
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                if(i==size-1) ret.add(n.val);
                //System.out.print(n.val + " ");
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
        }
        return ret;
        
    } 
}