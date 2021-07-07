// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Time Complexity :O(n) -> number of nodes
// Space Complexity :O(2ˆh) ~ O(n) -> Stack space h-> max height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
//  1. push the root element to the stack .
//  2. Calculate size of queue and push left and right nodes of the popped element into a new stack .
//  Do this x times(x is size of first stack before adding left and right nodes to the second stack ) and add lements to a templist.
// after looping x times ad this templist to main list.
// 3. Now replace first stack with second stack i.e(first stack = second stack) and add repeat above process but now add nodes in reverse
//   order of above(i.e right nodes and left nodes now) . return main list.
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeZigzagLevelOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean b = true;
        while(!stack.isEmpty()){
            List<Integer> templist = new ArrayList<>();
            Stack<TreeNode> stack2 = new Stack<>();
            int size = stack.size();
            if(b){
                while(size>0){
                    TreeNode current = stack.pop();
                    templist.add(current.val);
                    if(current.left!=null)  stack2.push(current.left);
                    if(current.right!=null) stack2.push(current.right);
                    size--;
                }
            }
            else{
                while(size>0){
                    TreeNode current = stack.pop();
                    templist.add(current.val);
                    if(current.right!=null)  stack2.push(current.right);
                    if(current.left!=null) stack2.push(current.left);
                    size--;
                }
            }
            stack = stack2;
            b = !b;
            result.add(templist);
        }
        return result;
    }
}
