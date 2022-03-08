//Time Complexity : O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully


import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideView199LeetCode {

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

        //DFS Approach
        List<Integer> list;                                         //creating the result list
        public List<Integer> rightSideView(TreeNode root) {

            list = new ArrayList<>();
            if(root == null){                                       //chech if root is null or not
                return list;                                        //if null then return empty list
            }
            rightSideView(root, 0);                                 //calling the function with root and its level which is zero
            return list;

        }
        public void rightSideView(TreeNode node, int level){

            if(node == null){                                       //check if node is null or not
                return;                                             //if null then simply return
            }

            if(list.size() != level){                               //check if list size is not equal to the level
                list.set(level, node.val);                          //if its not equal which means we already visited this level node, so we need to just update the value to current node's value
            }
            else{
                list.add(node.val);                                 //if not equal which means we haven't visited this level, so we just add the value into list
            }

            rightSideView(node.left, level+1);                  //calling the recusrive function with left side of the child and incraement the level
            rightSideView(node.right, level+1);                 //calling the recursive function with right side of the child and increament the level

        }



        //BFS Approach 2
//     public List<Integer> rightSideView(TreeNode root) {

//         List<Integer> list = new ArrayList<>();
//         if(root == null){
//             return list;
//         }

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int level=0;

//         while(!q.isEmpty()){

//             int size = q.size();

//                 for(int i=0; i<size; i++){

//                     TreeNode node = q.remove();

//                     if(i == size-1){
//                         list.add(node.val);
//                     }


//                 if(node.left != null){
//                     q.add(node.left);
//                 }

//                 if(node.right != null){
//                     q.add(node.right);
//                 }

//                 size--;
//             }
//             level++;
//         }
//         return list;

//     }







//     //BFS Approach
//     public List<Integer> rightSideView(TreeNode root) {

//         List<Integer> list = new ArrayList<>();
//         if(root == null){
//             return list;
//         }

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int level=0;

//         while(!q.isEmpty()){

//             int size = q.size();

//             while(size>0){

//                 TreeNode node = q.remove();

//                 if(list.size() != level){
//                     list.set(level, node.val);
//                 }
//                 else{
//                     list.add(node.val);
//                 }


//                 if(node.left != null){
//                     q.add(node.left);
//                 }

//                 if(node.right != null){
//                     q.add(node.right);
//                 }

//                 size--;
//             }
//             level++;
//         }
//         return list;

//     }

}
