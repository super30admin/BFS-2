// Time Complexity : O(n) where n is #nodes
// Space Complexity : O(n), this is the max queue size at any point, could be equal to #nodes at the last level 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out how to handle the case of cousins
// could do a level order traversal and see if nodes are found at the same level
// but hard to distinguish if neighbouring nodes are from the same parent or a child was missing
// hence was checking for it while adding the node to queue

// Your code here along with comments explaining your approach
// Idea is to do a level order traversal
// use a queue to process elements in a tree
// while adding check if nodes childrens values are the values, x and y, if not then add
// now check if x and y are found at the same level 

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        boolean foundX = false;
        boolean foundY = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            foundX = false;
            foundY = false;
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.val==x) foundX = true;
                else if(node.val==y) foundY = true;
                
                if(foundX && foundY) return true;
                
                if(node.left!=null && node.right!=null){
                    if((node.left.val==x && node.right.val==y) || (node.left.val==y && node.right.val==x)){
                        return false;
                    }
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }                
            }
        }
        
        return false;
    }
}


// Time Complexity : O(n), since we would traverse all nodes
// Space Complexity : O(log n), since only space we use would be the stack space 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// traversal all nodes and keep track of parent node and depth when we encounter node.val as x or y

class Solution {
    int depthX = -1, depthY = -1;
    int x, y;
    TreeNode parentX = null, parentY = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        TreeNode parent = null;
        int curDepth = 0;
        helper(root, parent, curDepth);
        
        return (depthX==depthY) && (parentX!=parentY);
    }
    
    private void helper(TreeNode node, TreeNode parent, int curDepth){
        if(node==null) return;
        
        if(node.val==x){
            depthX = curDepth;
            parentX = parent;
        }
        
        else if(node.val==y){
            depthY = curDepth;
            parentY = parent;
        }
        
        helper(node.left, node, curDepth+1);
        helper(node.right, node, curDepth+1);
    }
}