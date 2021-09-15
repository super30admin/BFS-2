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
// Time Complexity: We are traversing all the nodes providing O(n) time complexity
// Space Complexity: Using an additional queue of size of level O(n)
// Did you complete it on leetcode: Yes
// Any problems faced: missed check of left and right null while checking both child are x and y

// Write your approach here
// Idea here is to use the BFS solution to perform a check that if in a level order traversal
// if we found an element in the queue at a level, we check if another element is also in the queue at that level by iterating through size.
// we maintain 2 flags to identify if x and y are found
// then we check if polled element's left and right exist and both equals to x and y in any order
// they are sibling and not cousing, we return false
// otherwise we add all the child of current level's polled elements in queue until the queue is empty
// finally if both x and y are found then we can return true else either or both of them are not found
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y) return false;
        Queue<TreeNode> q = new LinkedList<>();
        boolean foundX = false;
        boolean foundY = false;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    foundX = true;
                    continue;
                }
                if(curr.val == y) {
                    foundY = true;
                    continue;
                }
                if(curr.left!=null && curr.right!=null){
                    if((curr.left.val == x && curr.right.val == y) ||
                       (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(foundX && foundY) return true;
            if(foundX || foundY) return false;
        }
        return false;
    }
}