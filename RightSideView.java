/*
Time Complexity : O(n)
Space Complexity : O(n)
 Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no

 Approach using BFS

 updated each level nodes into queue root and root left and root right 
 every will find the size of the queue and while popping the node from the queue if its the last elememnt of the queue then will add it
 to the result array
*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                if(i == size-1){
                    result.add(curr.val);
                }
                
            }
        }
        return result;
    }
}


/*
Time Complexity : O(n)
Space Complexity : O(n)
 Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no

 Approach using DFS

 Same as level order but here we are first going through right side of the tree and adding into the result array
*/

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return result;
        }
        dfs(root , 0);
        return result;
    }
    void dfs(TreeNode root , int level){
            if(root == null){
                return;
            }
            if(level == result.size()){
                result.add(root.val);
            }
            dfs(root.right, level+1);
            dfs(root.left, level+1);
        }
    }
