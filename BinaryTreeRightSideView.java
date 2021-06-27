// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Do a Level Order BFS Traversal and add the last node on each level to the result
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode rootNode = queue.remove();
                
                if(i == size-1) 
                    result.add(rootNode.val);
                
                if(rootNode.left != null) 
                    queue.add(rootNode.left);
                if(rootNode.right != null) 
                    queue.add(rootNode.right);
            }
        } 
        
        return result;
    }
}