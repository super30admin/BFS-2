class Solution{
    public boolean isCousins(TreeNode root, int x, int y){
        if(root == null) return false; // if the root is not there, we return 0;
        Queue<TreeNode> q = new LinkedList(); // we create a queue with name q which has the input as treenode.
        q.add(root); // we add the root to the queue
        while(!q.isEmpty){ // we check if the q is not empty
            int size = q.size(); // we take the size of the queue in an integer variable with name q.
            boolean x_found = false, y_found = false; // we are using 2 boolean variables whether x and y are found or not.
            for(int i = 0; i < size; i++){ // we run a loop through the q until we reach the end of the element.
                TreeNode curr = q.poll(); // if there is an element in the q, we pop the element from the q and store it in a variable called as curr of type treenode.
                if(curr.val == x){ // if the curr value is equal to x.
                    x_found = true; // we change x_found is equal to true
                }
                if(curr.val == y){ // if the curr value is equal to the value of y
                    y_found == true; // we change the y_found is equal to true
                }
                if(curr.left != null && curr.right != null && curr.left.val == x && curr.right.val == y){ // this means that they are having the same parent
                    return false; // so we return false
                }
                if(curr.left != null && curr.right != null && curr.left.val == y && curr.right.val == x){ // we could have the right value as x and left value as y. if thats the way it is, there is a change that both of them are having the same parent
                    return false; // we return false
                }
                if(curr.left != null){ // if the element towards the left is not null
                    q.add(curr.left); // we add that element to the queue
                }
                if(curr.right != null){ // if the element towards the right is not null
                    q.add(curr.right) // we add that element to the queue
                }
            }
            if(x_found == true && y_found == true){ // if x and y both are found,
                return true; // we return true
            }
            if(x_found || y_found){ // if one of x or y is found
                return false; // we return false
            }
        }
        return false; // we return false in the end.
    }
}
//tc - O(n) and sc - O(n)