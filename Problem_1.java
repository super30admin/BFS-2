/*

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

TC : O(n)
SC : O(n)
Leet Code : Yes

 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(i == size - 1){
                    res.add(node.val);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}