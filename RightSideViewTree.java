// Time Complexity :O(N) ---> we process each and every node in the tree
// Space Complexity :O(N) ---> and store it in an result
// Did this code successfully run on GeeksforGeeksEditor : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Queue<TreeNode> queue = new LinkedList<>();
    if(root == null)
        return res;
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0;i < size;i++){
            TreeNode curr = queue.remove();
            if(i == size-1){
                res.add(curr.val);
            }
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        
        
    }
        return res;
        
    }
    
    
}