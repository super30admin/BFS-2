//time - O(n)
//space - O(n)
class Solution {
    List<Integer> result;
    Queue<TreeNode> q;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        q = new LinkedList<>();
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(i==size-1){
                    result.add(temp.val);
                }
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }

        return result;
    }
}
