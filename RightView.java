//Time: O(N) --> no of nodes
//Space: O(H) --> height of tree for recursive stack

class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        rightSideView(root,0);
        return result;
    }
    
    //every level add only one node to result
    private void rightSideView(TreeNode node, int level) {
        //NLR (preorder)
        
       /* if(node == null)
            return;
        
        if(result.size() == level) {
            //no entry corresponding to this lvel
            //add node to list
            result.add(node.val);
        } else { //entry already exists,then update
            result.set(level, node.val);
        }
        
        rightSideView(node.left, level+1);
        rightSideView(node.right, level+1);
        */
        
        
        //NRL-processing right node first
        if(node == null)
            return;
        
        if(result.size() == level) {
            //no entry corresponding to this lvel
            //add node to list
            result.add(node.val);
        }
        //if result already exists move on to processing next level
        
        rightSideView(node.right, level+1);
        rightSideView(node.left, level+1);
        
        
        
    }
}