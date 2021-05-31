// Time: O(n) where n= number of nodes
//space: O(2^h) where h=height of tree
//DId it run successfully on leetcode: yes
// Did you face any problem: no

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //list to store result;
        List<Integer> res = new ArrayList<>();
        //if root is null
        if(root==null) return res;
        //Queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);
        //until queue is empty
        while(!q.isEmpty()){
            //get number of nodes in current level
            int size = q.size();
            //for all nodes in current level
            for(int i=0; i<size; i++){
                //get curr node
                TreeNode curr = q.poll();
                //if it is the last node
                if(i== size-1){
                    //add to result
                    res.add(curr.val);
                }
                //if curr has left child
                if(curr.left != null){
                    //add child to queue
                    q.add(curr.left);
                }
                //if curr has right child
                if(curr.right != null){
                    //add child to queue
                    q.add(curr.right);
                }
            }
        }

        return res;

    }
}