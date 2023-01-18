// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//bfs - in this solution we traverse level wise and at each level we add the right value to the result if the size of the list
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);    
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}

//dfs with right first
// Time Complexity : O(n)
// Space Complexity : O(h)
//in this solution we recurse on the right and add values when size is equal to the depth. We add the values on the left if again the size of the result list
//is equal to depth otherwise we ignore the left 
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result= new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int depth){
        if(root == null)return;

        if(result.size()==depth)result.add(root.val);
        dfs(root.right,depth +1);
        dfs(root.left,depth+1);
    }
}

//dfs with left first
//in this solution we recurse on the left and add values when size is equal to the depth. We modify the values when we reach the right.
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result= new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int depth){
        if(root == null)return;

        if(result.size()==depth)result.add(root.val);
        else result.set(depth,root.val);
        dfs(root.left,depth+1);
        dfs(root.right,depth +1);
        
    }
}