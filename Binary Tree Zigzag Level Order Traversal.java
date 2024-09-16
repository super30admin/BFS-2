/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// Recursion solution
// We check for even oand odd levels and add to approprate list from beginning or end

// Beats 96 % of Leet Code Submsissons

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        
        levelOrder(res, root, 0);
        
        return res;
    }
    
    public void levelOrder(LinkedList<List<Integer>> res, TreeNode root, int level){
        
        if(root == null) return;
        
        if(res.size() <= level)
            res.add(new LinkedList<Integer>());
        
        if(level % 2 == 0) res.get(level).add(root.val); // if even add at the end
        else res.get(level).add(0, root.val); // if odd level add at the beginning
       
        levelOrder(res, root.left, level + 1);
        levelOrder(res, root.right, level + 1);
        
    }
}

// BFS Solution
// T: O(N)
// S: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
       
        
        if(root == null)    return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        boolean alter = false;
        
        while(!q.isEmpty()){
            
            int count = q.size();
            ArrayList<Integer> individualList = new ArrayList<Integer>();
            
            for(int i = 0; i < count; i++){
                
                TreeNode temp = q.remove();
                individualList.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null)  q.add(temp.right);
                
            }
            
            if(alter){
                Collections.reverse(individualList);
                alter = false;
            }
            else{
                alter = true;
            }
            
            result.add(individualList);
        }
        
        return result;
    }
}