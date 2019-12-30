
//BFS
// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(B) where B is the breath of the tree
// This solution worked on LeetCode


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();       // Create a resultant List for output
        if(root == null)    return result;              //If root is null return empty result list
        Queue<TreeNode> q = new LinkedList<>();     
        q.add(root);                                    // Add the root to the queue
        int size =0;                                    // Size is used to keep record the length of level 
        while(!q.isEmpty()){        
            size = q.size();                            // size will be the number of elements in the queue which are levels of the tree
            Integer temp =0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();                       // Poll the node
                temp = node.val;                                // Use the temp variable that will used to get the most recent which is the rightmost node value in the queue
                if(node.left != null) q.add(node.left);         // Add the left child of the node to the queue
                if(node.right != null) q.add(node.right);       // Add the left child of the node to the queue
            }
            result.add(temp);
        }
        return result;
    }
}
