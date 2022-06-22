
// Time complexity: O(n)
// Space Complexity: O(n)
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
         res = new ArrayList<>();
        if(root==null) return res;
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
           TreeNode curr = q.poll();
           if(i == size - 1) res.add(curr.val);
           if(curr.left!=null) q.add(curr.left);
        if(curr.right!=null) q.add(curr.right);
       }
        }
        return res;
    }
}
