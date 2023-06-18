# BFS-2

## Problem 1

## Approach
Do preorder traversal.
If current node's value is either "x" or "y" then add the level as key and node's parent value as value in hashmap.

For first encounter the value will be added as hashmap will be empty.
After second encounter it will whether any other key is present if yes then check its value , if value's are same that means parent is same return false else return true.


Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

## Approach 
if the depth of current node is greater than maximum depth till the previous recursive call, then add to the list.

## Solution

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
    List<Integer> result = new ArrayList<>();
    int max_depth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        
        helper(root,1);
        return result;
    }

    void helper(TreeNode root,int depth){

        if (root == null) return;
        
        if(max_depth < depth){
            max_depth = depth;
            result.add(root.val);
        }
        System.out.println(root.val + " " + depth + " " + max_depth);
        // result.add(root.val);
        depth = depth + 1;
        helper(root.right,depth);
        helper(root.left,depth);
    }
}


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

## Solution
## Solution
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    boolean flag = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(root,x,y,0,0);
        System.out.println(map);
        return flag;
    }

    void helper(TreeNode root, int x, int y,int prev,int level){

        if(root == null)return;
        level = level + 1;
        System.out.println(root.val + " "+ level);
        
        if(root.val == x || root.val == y){
            if(map.containsKey(level)){
                if(map.get(level) == prev){
                    flag = false;
                }else{
                    flag = true;
                }
                return;
            }else{
                map.put(level,prev);
            }
            
        }
        prev = root.val;
        helper(root.left,x,y,prev,level);
        helper(root.right,x,y,prev,level);
    }
}

