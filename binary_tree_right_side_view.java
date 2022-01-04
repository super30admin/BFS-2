class Solution{
    public List<Integer> rightSideView(TreeNode root){
        if(root == null) return new ArrayList<>(); // if there is no root, we simply return the empty arraylist.
        Queue<TreeNode> q = new LinkedList<>(); // we create a queue which takes the inputs as the TreeNode which stores the elements that we encounter while we are traversing throguh the binary tree
        List<Integer> list = new Linkedlist(); //we create a list which takes the input as the integer which stores the values that we encounter while we go through the list. this list shows the values that give the right side view of the tree.
        q.add(root); // we add that root to the queue.
        while(!q.isEmpty()){ // we check if the q is not empty. if the queue is not empty,
            int size = q.size(); // we check the size of the queue and store it in a variable called as size.
            for(int i = 0; i < size; i++){ // we go through the elements present in the queue.
                TreeNode curr = q.poll();// we pop the element from the queue and store it in a variable called as curr of type treenode.
                if(i == size - 1){ // we check if the element present at i is the last element of the queue. if i is the last element, it can be seen in the right side view of the binary tree
                    list.add(curr.val); //we add it to the list which has stores all the result values.
                }
                if(curr.left != null){ // we check if there are any nodes towards the left of the current node.
                    q.add(curr.left); // if there are any, we add them to the queue.
                }
                if(curr.right != null){ // we check if there are any nodes towards the right of the current node.
                    q.add(curr.right); // if there are any, we add them to the queue.
                }
            }
        }
        return list; // we return the list in the end.
    }
}
//tc and sc - O(n);