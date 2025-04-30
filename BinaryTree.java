//Use function parameters when the state flows from root → leaves
// Use return values when the state flows from leaves → root
 //Time Complexity : O(n)
 //Space Complexity: O(n)
 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();  

        List<Integer> result = new ArrayList<>();

        if(root ==null){
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i<size; i++){

                TreeNode currNode = queue.poll();

                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }

                if(i == size-1){
                    result.add(currNode.val);
                }
            }
        }
        return result;

        
    }
}