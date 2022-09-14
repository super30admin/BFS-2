// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * In this dfs approach, we are comparing the depth at each level to the size of result list.
 * if the depth is same as side, we will be adding the node to our list.
 * We are making right calls first to get the right view. This can also be done bt making left calls first.
 * In that case, we would be putting another condition of result.set(depth, root.val) like replacing the value.
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        //dfs approach

        if(root==null) return result;

        //initially depth would be zero
        dfs(root,0);

        return result;


    }

    //dfs function
    private void dfs(TreeNode root, int depth){

        //base case
        if(root==null) return;


        //logic
        if(depth == result.size()){
            result.add(root.val);
        }

        //making right calls first
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);



    }


}


/**
 * In BFS approach, at each level the last element that comes up , we will add it to our list . We will maintain a
 * queue.
 * Time : O(N), Space: O(N)
 */


//    public List<Integer> rightSideView(TreeNode root) {
//
//        //output list
//        List<Integer> result = new ArrayList<>();
//
//        if(root == null) return null;
//
//        Queue<TreeNode> q = new LinkedList<>();
//
//        //adding root to the queue
//        q.add(root);
//
//        int size = q.size(); //size will maintain the level
//
//        //iterate over the queue and pop the element
//        for(int i=0; i<size; i++){
//
//            //Returns and removes the head of the queue.
//            TreeNode node = q.poll();
//
//            //add to result if last element
//            if(i == size-1){
          //       result.add(node.val);
//        }
//          if(node.left!=null) q.add(node.left);
//          if(node.right!=null) q.add(node.right);
//
//                  }
//                  }
//                  return result;
//
//    }