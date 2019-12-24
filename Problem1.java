/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

The idea is to use queue to do BFS to find nodes at the same level or depth and then check if they both have same parent or not. This can be done by recursively calculating parent or having a parent array.
**/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == y)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        int[] parent = new int[101];
        Arrays.fill(parent,-1);
        
        q.add(root);
        int checkX = 0;
        int checkY = 0;
        while(!q.isEmpty()){
            checkX = 0;
            checkY = 0;
            int currentLevelSize = q.size();
            while(currentLevelSize > 0){
                TreeNode temp =  q.poll();
                if(temp.val == x)
                    checkX = x;
                else if(temp.val == y)
                    checkY = y;
                
                //Nodes at Same Depth 
                if(checkX != 0 && checkY != 0){
                    return checkParent(root,checkX) != checkParent(root,checkY);
                    //return parent[checkX] != parent[checkY];
                }
                
                if(temp.left != null){
                    q.add(temp.left);
                    parent[temp.left.val] = temp.val;
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                    parent[temp.right.val] = temp.val;
                }
                
                currentLevelSize --;
            }
            if(checkX != 0 || checkY != 0){
                    return false;
            }
        }
        
        return false;
        
    }
    
    private int checkParent(TreeNode root, int val){
        
        if(root == null)
            return 0;
        
        if(root.left != null && root.left.val == val){
            return root.val;
        }
        
        if(root.right != null && root.right.val == val){
            return root.val;
        }
        
        
        int left = checkParent(root.left,val);
        int right = checkParent(root.right,val);
        
        return Math.max(left,right);
    }
}
