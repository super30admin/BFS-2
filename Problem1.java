//Time Complexity: O(n)
//Space Complexity: O(n)
//Ran in Leetcoode: yes

//Vist all the child nodes at each level and add to the result whihc is a BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){ 
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currNode = queue.poll();
                if(i == size-1){
                    result.add(currNode.val);
                }
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                 if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }
        return result;
    }
}