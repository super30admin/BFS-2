//Time Complexity :O(n)
//Space Complexity:O(n)
//Amazon interview
//Using BFS: The BFS starts from root, Consider x and y if found then return false elese it should return true.It compares the root of tree with sub trees example consider the root as parent of same child it should compare the left and right child of the tree.Go into the loop again and check, if found it should return x and y else to remove the current element from queue treenode and loop continues and checks againg and again but here it will contiue it returns also then starts continue of the loop it wont go back if not found.
//In java int =automatically initialize to zero
//Int java TreeNode =automatically initialize to null, it start from root then its previous node it should be null 
//In java boolean =automatically initialize to false
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();//Local variable
        //Using BFS Solution
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(i == size-1) {
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}