TC: 
SC: 

Runtime: 1 ms, faster than 70.52% of Java online submissions for Cousins in Binary Tree.
Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Cousins in Binary Tree.

In each level , we create a hashmap add node and its parent as key and pair.
After one level is finished added to hashmap, we check whether x,y are present with different parents.


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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){   // to get all the levele
            
        Map<Integer,TreeNode> hash = new HashMap<>();
            int size = q.size();
            for(int i=0; i<size; i++){   // to get the elements in that particular level
                TreeNode temp = q.poll();
            if(temp.left != null){
                    q.add(temp.left);
                hash.put(temp.left.val,temp);
            }
            if(temp.right != null){
                    q.add(temp.right);
                hash.put(temp.right.val,temp);
            }
        }
        if(hash.containsKey(x) && !hash.containsKey(y) || !hash.containsKey(x) && hash.containsKey(y)) return false;
        if((hash.containsKey(x) && hash.containsKey(y) && hash.get(x)!= hash.get(y))) return true;
        
        
    }
        return false;
    }
}
