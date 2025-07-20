// Time Complexity : O(n) -> since we are traversing all elements of the TreeNode
// Space Complexity : O(n) -> Queue will at most contain the elements equal to the maximum breadth of the tree
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        //base case
        if(root == null){
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            //get size
            int size = q.size();

            //counter for x and y
            int counter = 0;

            //run loop and check if both the childs exists in this size
            for(int i = 0; i < size; i++){

                //pop
                TreeNode curr = q.poll();

                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.right.val == x && curr.left.val == y) return false;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

                if(curr.val == x || curr.val == y){
                    counter++;
                }

                if(counter == 2){
                    return true;
                }

            }

        }
        
        return false;

    }
}