// Time complexity O(n) - n is number of nodes
//Space complexity O(h) - nodes at last level of the tree

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int size=0;
        //null case
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    res.add(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
    
}