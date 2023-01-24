// ######### APPROACH 1: BFS ###################
// Time Complexity: O(n)
// Space Complexity: O(n)

// Approach
// We traverse the nodes level by level but only add the rightmost nodes to the result array list
// We create a result arr list. Then we create a queue and add the root node.
// While the queue is not empty, get the size of the queue and traverse over the nodes in that level 
// Poll the current element in queue and check if it is the rightmost element (last element in size) in that level (i==size-1), if yes, add it to the result
// add the left and right child to the queue if present.
// Base condition: if root ==null return empty result.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        
        if(root==null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                
                // get the right side view/ right most element in that level
                if(i==size-1){ //i==0 for left size view
                    result.add(curr.val);
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return result;
        
    }
}

// ######### APPROACH 2: DFS ###################
// Time Complexity: O(n)
// Space Complexity: O(H)

// Approach:
// We need to keep depth variable so that when we come to the same depth level recursively we add the node to the resulting arr list
// In recursive call we check the above condition
// Since this is right side view, we do right recursive call and then left recursive call
// For left side view, we would do left rec call and then right.


class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        helper(root,0);
        return result;
        
    }
    private void helper(TreeNode root, int depth){
        
        if(root==null) return;
        
        if(depth==result.size()){
            result.add(root.val);
        }
        
        helper(root.right,depth+1);
        helper(root.left,depth+1);
        
    }
}