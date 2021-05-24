/*
Desc : We do a level order traversal and take the right most element out of every level to put it into the resultant array
Time Complexity : O(n)
Space Complexity : O(1)
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==size-1) result.add(curr.val);
                if(curr.left !=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return result;
    }
}
