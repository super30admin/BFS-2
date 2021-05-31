//Time: O(n), n= num of nodes
//space : O(2^h), where h=height of tree
// Did it run successfully on leetcode: yes
//Did you face any problem: no
class CousinBinaryTrees {
    public boolean isCousins(TreeNode root, int x, int y) {
        //Queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);

        //until queue has element
        while(!q.isEmpty()){
            //get size of queue
            int size = q.size();
            //variable to keep track if x and y is found
            boolean foundX = false, foundY=false;
            //for all the nodes in the same level
            for(int i=0; i<size; i++){
                //get curr node
                TreeNode curr = q.poll();
                //if curr node is equl to x
                if(curr.val == x) foundX = true;
                //if curr node is equl to y
                if(curr.val == y) foundY = true;
                //if current has both left and right child
                if(curr.left!=null && curr.right!=null){
                    //if value of x and y matches with children of curr
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                //if left children exist, add to queue
                if(curr.left!=null) q.add(curr.left);
                //if right children exist, add to queue
                if(curr.right!=null) q.add(curr.right);
            }
            //if x and y found
            if(foundX && foundY) return true;
            //if only one of them is found
            if(foundX || foundY) return false;

        }
        //if not cousin
        return false;

   }

}