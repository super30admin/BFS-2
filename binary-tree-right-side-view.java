// soultion-BFS-1
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:this is BFS approach where i process the queue by taking size and polling the elements on level basis taking last element
// from the queue size at that time where index is equal to last elemetn then i am adding that to result because we need to get right element .
class Solution {
    List<Integer> result=new ArrayList<>();
       public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
           while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(i == size-1){
                    result.add(current.val);
                }
            
        if(current.left != null){
             q.add(current.left);
        }
         if(current.right != null){
            q.add(current.right);
        }
            }


        }
        return result;
    }
  
}

// soultion-DFS-1
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only: this is dfs recursive approch where i need to get right elements of the tree so first i process root of right in recursive, if size of result array is not equal to result size then it means the corresponding level right element 
//not been in the array so i have added it to result
class Solution {
    List<Integer> result=new ArrayList<>();
       public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return result;
        result.add(root.val);
         helper(root,0);
        return result;
    }
    public void helper(TreeNode root,int level){
        if(root == null)return;
        // level++;
        if(result.size() == level){
            result.add(root.val);
        }
        helper(root.right,level+1);
        helper(root.left,level+1);

    }
}

// soultion-DFS-2
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach in three sentences only:same as above dfs approch but here i am processing this from left where if the level element already exist i am just replacing it with new elements because we need to get right element where we are processing left element first

class Solution {
    List<Integer> result=new ArrayList<>();
       public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return result;
        result.add(root.val);
         helper(root,0);
        return result;
    }
    public void helper(TreeNode root,int level){
        if(root == null)return;
        // level++;
        if(result.size() == level){
            result.add(root.val);
        }else{
             result.set(level,root.val);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);

    }
}