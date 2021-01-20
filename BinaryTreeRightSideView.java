// Time Complexity : O(n)
// Space Complexity : O(h) , h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a recursive function with a local variable as height of the tree, and goto the rightmost sub tree, while adding the right-most node values to the result tree and then goto the left subtree and repeat.

public class BinaryTreeRightSideView {
    //Solution 1: DFS
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;
        
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int height){
        if(root == null) return;
        
        if(height >= result.size()){
            result.add(root.val);
        }
        
        helper(root.right, height + 1);
        helper(root.left, height + 1);
    }

    // Solution 2: BFS
    // List<Integer> result;
    // public List<Integer> rightSideView(TreeNode root) {
    //     result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     Queue<TreeNode> q = new LinkedList<>();
        
    //     q.add(root);

    //     while(!q.isEmpty()){
  
    //         int size = q.size();
    //         for(int i = 0; i < size; i++){
    //             TreeNode currentNode = q.poll();
                
    //             if(i == size - 1){
    //                 result.add(currentNode.val);
    //             }
                
    //             if(currentNode.left != null) q.add(currentNode.left);
    //             if(currentNode.right != null) q.add(currentNode.right);
    //         }   
    //     }
        
    //     return result;
    // }
}
