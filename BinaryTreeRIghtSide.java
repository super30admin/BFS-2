// TC = O(n)
// SC = O(n)
// Here we are using BFS. 
//We are using queue to maintain the elements in each height. And we will return the last element of list

class BinaryTreeRIghtSide{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                 if(i == size-1){
                     result.add(curr.val);
                }
                 if(curr.left != null) q.add(curr.left);
                 if(curr.right != null) q.add(curr.right);
            }   
        }
        return result;
    }
}