/**
 * Time Complexity: O(n)
 * Space Complexity: O(n+n) ~ O(n)
 * Idea
 * 1.Maintain two stacks for current level and next level. Toggle a flag to maintain order of pushing children
 * 2. Add level wise elements to a temp list adn add to reasult
 * Leetcode:
 * Yes
 *  */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class ZigZagTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        boolean leftToRight = true;
        currentLevel.push(root);
        List<Integer> tempList = new ArrayList<>();
        while(!currentLevel.isEmpty()){

            TreeNode curr = currentLevel.pop();
            tempList.add(curr.val);

            if(leftToRight){
                if(curr.left != null) nextLevel.push(curr.left);
                if(curr.right != null) nextLevel.push(curr.right);
            }
            else {
                if(curr.right != null) nextLevel.push(curr.right);
                if(curr.left != null) nextLevel.push(curr.left);
            }

            if(currentLevel.isEmpty()){
                
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = new Stack<>();
                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                //currentLevel = new Stack<TreeNode>(nextLevel);
                //nextLevel = new Stack<TreeNode>();
                result.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        return result;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Zigzag");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ZigZagTreeTraversal obj = new ZigZagTreeTraversal();
        System.out.println(obj.zigzagLevelOrder(root));

        
    }
}