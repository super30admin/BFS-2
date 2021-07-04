/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) - extra BFS queue
 * Idea: 
 * 1. Visit very node in BFS fashion and track parents for given nodes.
 * 2. At end of each level traversal check if parent nodes are different, return true if different.
 * 
 * Leetcode: Yes
 */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {


        Queue<TreeNode> mq = new LinkedList<>();
        TreeNode xParent = null;
        TreeNode yParent = null;
        mq.add(root);
        while(!mq.isEmpty()){
            int numberOfNodes = mq.size();
           
            for(int i=0;i<numberOfNodes;i++){
                TreeNode curr = mq.poll();            
              
                if(curr.left != null){     
                    if(curr.left.val == x){
                        xParent = curr;
                    }
                    if(curr.left.val == y) yParent = curr;
                    mq.add(curr.left);

                }
                if(curr.right != null){
                    if (curr.right.val == x){
                        xParent = curr;
                    } 
                    if(curr.right.val == y) yParent = curr;
                    mq.add(curr.right);
                }
            } 
            if(xParent!= null && yParent != null && xParent != yParent){
                return true;
            }

            xParent = null;
            yParent = null;
        }
        return false;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("CousinsInBinaryTree");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        CousinsInBinaryTree obj = new CousinsInBinaryTree();
        System.out.println(obj.isCousins(root, 2, 3));
    }
}