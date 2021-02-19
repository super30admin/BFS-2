//TC : O(n)
//Space Complex : O(n)
//Approach : We are doing level order traversal,BFS and updating the parent of x
// and parent of y,if they are equal we return false;
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
        if(root==null){
            return false;
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,-1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int parent_x=-1;
            int parent_y=-1;
            
            
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int parent = pair.getValue();
                
                if(node.val==x){
                    parent_x=parent;
                }else if(node.val==y){
                    parent_y=parent;
                }
                
                if(node.left!=null){
                    queue.add(new Pair<TreeNode,Integer>(node.left,node.val));
                }
                
                if(node.right!=null){
                    queue.add(new Pair<TreeNode,Integer>(node.right,node.val));
                }
            }
            
            if(parent_x!=-1&&parent_y!=-1&&parent_x!=parent_y){
                return true;
            }else if((parent_x==-1 && parent_y!=-1)||(parent_x!=-1&&parent_y==-1)){
                return false; 
            }
                
        }
        return false;
    }
}
