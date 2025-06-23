//starting from the right child first to collect the first node seen at each depth, effectively capturing the right-side view of a binary tree. It adds a node's value to the result list only if the current depth hasn't been recorded yet.
//Time Complexity: O(n)
//Space Complexity: O(h)

class Solution {

   public List<Integer> rightSideView(TreeNode root) {

       List<Integer> result = new ArrayList<>();

       view(root,result,0);

       return result;

   }

   public void view(TreeNode root,List result,int depth){

       if(root==null) return;

       if(depth==result.size())

           result.add(root.val);

       view(root.right,result,depth+1);

       view(root.left,result,depth+1);

   }

}