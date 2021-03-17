// Time Complexity :
O(no.of nodes in the tree)
// Space Complexity :
O(n) as we are using a queue to add children at each level
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
    public boolean isCousins(TreeNode root, int x, int y) {
    if(root == null) return false;
    
    //Define a Queue to store the current node and the parent node value while doing BFS
    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    
    //Initialise the queue with the root node
    queue.add(new Pair<TreeNode,Integer>(root, -1));
    
    //Start BFS
    while(!queue.isEmpty()){
        int size = queue.size();
        //initialize two variables to store parent of x and y
        int parentx = -1;
        int parenty = -1;
        for(int i=0; i< size; i++){
            //Pop the values from queue
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode currentNode = pair.getKey();
            int parentNodeVal = pair.getValue();
            
            //check if currentNode is equal to my given x or given y
            if(currentNode.val == x){
                //change parentx
                parentx = parentNodeVal;
            }else if(currentNode.val == y){
                parenty = parentNodeVal;
            }
            
            /*if the above conditions fail, then we have to populate the queue and continue BFS*/
            
            if(currentNode.left != null) {
            queue.add(new Pair<TreeNode, Integer>(currentNode.left,currentNode.val));  
            }
            
            if(currentNode.right != null) {
            queue.add(new Pair<TreeNode, Integer>(currentNode.right,currentNode.val));  
            }
            
            }
        
        if(parentx != -1 && parenty != -1 && parentx != parenty) return true;
else if((parentx == -1 && parenty != -1) || (parentx != -1 && parenty == -1)) return false;
            
    }
        
        return false;
    }
}