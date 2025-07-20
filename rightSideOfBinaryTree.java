// Time Complexity : O(n) -> since we are traversing all elements of the TreeNode
// Space Complexity : O(n) -> Queue will at most contain the elements equal to the maximum breadth of the tree
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

//Your code here along with comments explaining your approach in three sentences only


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        //base case
        if(root == null){
            return new ArrayList<>();
        }

        //result
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            //get size
            int size = q.size();

            //run loop until size - 1
            for(int i  = 0; i < size; i++){
                
                //pop
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

                if(i == size - 1){
                    res.add(curr.val);
                }

            }

        }

        return res;

    }
}