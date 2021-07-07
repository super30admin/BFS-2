//BFS
//Time Complexity : O(n)
//Space Complexity : O(n). O(n/2) because not all nodes are added into the queue

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //add the root to queue
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = null;
            int size = q.size();
            //iteate for each level
            for(int i=0;i<size;i++){
                cur = q.poll();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            //add the rightmost element from the queue after exiting from the level
            result.add(cur.val);
        }
        return result;
    }
}
//DFS
//Time Complexity : O(n)
//Space Complexity: O(h).h is height of the tree. Ifrecurssive stack is taken into consideration then the space complexity is O(n)
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return result;
        }
        //helper function
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        //if the list size is equal to level then add its value.
        if(result.size() == level){
            result.add(root.val);
        }
        //traverse from right to left instead of left to right
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}