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

//Approach 1 BFS

class Solution {

    //Time Complexity: 0(n)
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while solving: No

    //In short explain your approach: I Firstly I solved using a BFS approach for which I took a queue to store the nodes at each
    //level. The root goes in the queue 1st. Then the while loop runs till my queue is empty. Then I calculate the size of queue
    //at every instance. The for loop runs for the size of the loop. As per the algo, the right side view is always located at the
    //last index of the queue. Hence, when the queue hits the last index, then that gets added to the resultant list. Then I
    //also traverse the left and right node of the of the tree storing it in the queue and return the final resultant list.

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List <Integer> result = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(i == size-1){
                    result.add(current.val);
                }
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
        return result;
    }
}

//DFS

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
    List <Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        helper(root.right, level + 1);
        helper(root.left, level + 1);
        return;
    }
}

//DFS traversing left
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
    List <Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level,root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
        return;
    }
}