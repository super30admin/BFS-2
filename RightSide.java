// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        //BFS
        /*List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();//FIFO so

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == size -1){
                    res.add(curr.val);
                }

                if(curr.left!= null){
                    q.add(curr.left);
                }

                if(curr.right!= null){
                    q.add(curr.right);
                }
            }
        }
        
        return res;*/

        //DFS
        List<Integer> res = new ArrayList<>();
        
        dfs(root, 0, res);

        return res;
    }

    private void dfs(TreeNode root, int lvl ,List<Integer> res ){
        
        
        if(root == null) return;
        if(lvl == res.size()){
            res.add(root.val);
        }

        dfs(root.right, lvl+1, res);
        dfs(root.left, lvl+1, res);

         
    }
}