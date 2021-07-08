// Time Complexity : O(n) where n is the number of nodes in Binary Tree
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: We maintain pointers for height and parent. Since these are two main conditions to be checked
for a cousin validity. We maintain depth pointers and as we do DFS we increment the depth. Also, we keep track of the parent for each of the node. At the point
when I have found my x node value and y node value, I note down my parent of x and parent of y using the parent pointer maintained in DFS. Similarly, 
at that moment, I also note down the height reached till now as I find x and y. Now compare their parents and heights, if any violation on the cousin
condition, return false else return true.
*/

// DFS 
class Solution {
    int x_depth, y_depth;                                                           // Pointers for Height
    TreeNode x_parent, y_parent;                                                        // Pointers for Parent
    public boolean isCousins(TreeNode root, int x, int y) {
    if(root == null){return false;}
    dfs(root, x, y, 0, root);
    return x_depth == y_depth && x_parent != y_parent;                                  // Cousin Condition
    }
    private void dfs(TreeNode root, int x, int y, int h, TreeNode parent){
        if(root == null){return;}
        if(root.val == x){                                                          // x found
            x_depth = h;                                                            // Record its parent and height
            x_parent = parent;
        }
        if(root.val == y) {                                                         // y found
            y_depth = h;                                                            // Record its parent and height
            y_parent = parent;
        }
        dfs(root.left, x, y, h + 1, root);                                              // Recurse over the left and right
        dfs(root.right, x, y, h + 1, root);
    }
}


//   BFS 
public boolean isCousins(TreeNode root, int x, int y) {
    int x_found = 0, y_found = 0;                                               // Found pointers for x and y
    TreeNode x_parent = null, y_parent = null;                                  // Parent pointers for x and y
    if(root == null){return false;}
    Queue<TreeNode> queue = new LinkedList<>();                                 // BFS Time
    queue.add(root);
    while(queue.size() >  0){
        int size = queue.size();
        x_found = 0;
        y_found = 0;                                                            // I am starting to search for x and y for this queue size
        for(int i  = 0; i < size; i++){
        TreeNode node = queue.poll();
        if(node.val == x){x_found = 1;}                                         // My node is equal to x or y
        if(node.val == y){y_found = 1;}
        if(node.left != null && node.right != null){
        if(node.left.val == x && node.right.val == y){return false;}            // Violation condition: they turn out to be siblings
        if(node.right.val == x && node.left.val == y){return false;}  
        }
        if(node.left != null) queue.add(node.left);                             // BFS using queue
        if(node.right != null) queue.add(node.right);
        }
        if(x_found == 1 && y_found == 1){return true;}                          // Both the values have been found and since I maintain size pointer it means they both are in same level
    }
        return false;
    }
}