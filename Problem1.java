
//BFS
// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(B) where B is the breath of the tree
// This solution worked on LeetCode


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size =0;
        while(!q.isEmpty()){
            size = q.size();
            Integer temp =0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                temp = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(temp);
        }
        return result;
    }
}
