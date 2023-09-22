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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);
        return result;



    }


    private void dfs(TreeNode root, int depth, List<Integer> result){
        if(root == null) return;

        if(result.size() == depth){
            result.add(root.val);
        }
        else{
            result.set(depth, root.val);
        }


        dfs(root.left, depth+1, result);

        dfs(root.right, depth+1, result);
    }
}





/**

BFS 

TC - O(n)- Iterating all the nodes
SC - O(n/2) = O(n), The width of the leaf nodes. 

Approach : 

1. Taking a root node and pushing inside my Queue. 
2. Maintaining Size to chek the ditinct elements, which means Maintaining level because to choose the last element inside my level. 
3. if my index is equal to size -1 then I am pusing inside my list. 
4. Adding My left and right child to my queue and repeating till my queue is empty. 



DFS 

TC - O(n)- Iterating all the nodes
SC - O(n/2) = O(H), The Hight of the tree nodes. 

Approach : 

1. Taking a root node and pushing inside my stack with depth as 0 and list. 
2. If my List size and depth is equal that means I dont have a value with this Index. So adding the root value inside my list. 
3. If both sizes are not equal, that means I already have a value with tht index so replacing by using set method. 
4. Returing the list. 





 */
