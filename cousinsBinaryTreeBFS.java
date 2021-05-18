// Time complexity - O(n)
// Space complexity - O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
class Pair{
    
    int level;
    TreeNode root;
    Pair(){}
    Pair(TreeNode root, int level){
        
        this.root = root;
        this.level = level;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<Pair> q1 = new LinkedList<>();
        Pair p1 = new Pair(root,0);
        q1.add(p1);
        boolean found_x = false;
        boolean found_y = false;
        TreeNode parent_x = null;
        TreeNode parent_y = null;
        int level_x = 0;
        int level_y = 0;
        while(!q1.isEmpty()){
            
           int queueSize = q1.size();
            // System.out.println(q1);
            
            
            for(int i = 0; i < queueSize; i ++){
                Pair current = q1.poll();
            TreeNode tempRoot = current.root;
              //  System.out.println(current.root.val);
            int tempLevel = current.level;
                
                if(tempRoot.left != null && tempRoot.left.val == x || tempRoot.right != null && tempRoot.right.val == x  ){
                  //  System.out.println("Hitting");
                    found_x = true;
                    level_x = tempLevel + 1;
                    parent_x = tempRoot;
                }
                if(tempRoot.left != null && tempRoot.left.val == y || tempRoot.right != null && tempRoot.right.val == y  ){
                 //   System.out.println("Hitting...."+tempRoot.val);
                    found_y = true;
                    level_y = tempLevel + 1;
                    parent_y = tempRoot;
                }
                
                if(tempRoot.left != null){
                    
                  //   System.out.println("Hitting.left left left..."+tempRoot.val);
                    Pair p2 = new Pair(tempRoot.left,tempLevel+1);
                    
                    q1.add(p2);
                }
                if(tempRoot.right != null){
                    
                    // System.out.println("Hitting. right right right..."+tempRoot.val);
                    Pair p2 = new Pair(tempRoot.right,tempLevel+1);
                    
                    q1.add(p2);
                }
            }
            if(found_x == true && found_y == true){
                
                if(level_y == level_x && parent_x != parent_y){
                    
                    return true;
                }
                else {
                    
                    return false;
                }
            }
            
            
            else if(found_x == true && found_y == false || found_x == false && found_y == true){
                
             //    System.out.println("Hitting123");
                
                return false;
            }
            
        }
        return false;
    }
}