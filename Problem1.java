class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root ==null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            List<Integer> result1 = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();
                result1.add(curr.val);
                if(curr.left!=null ){
                    queue.add(curr.left);
                }
                if(curr.right!=null ){
                    queue.add(curr.right);
                }
            }
            result.add(result1.get(size-1));
        }
        return result;
    }
}