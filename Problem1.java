//Problem-1
//199. Binary Tree Right Side View

//TC = O(n) where n is total number of nodes
//SC = O(b) where d is breadth of tree

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new LinkedList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int rightside = 0; 
            for(int i = 0; i < size; i++){
                TreeNode a = q.poll();
                if(a.left != null){
                    q.add(a.left);
                }
                if(a.right != null){
                    q.add(a.right);
                }
                rightside = a.val;

            }
            result.add(rightside);
        }
        return result;
    }
}
