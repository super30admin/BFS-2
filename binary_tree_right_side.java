 //TC-O(n)
 //SC-O(h)
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root == null) return result;
       dfs(root, 0, result);
       return result;
    }

    private void dfs(TreeNode root, int depth,  List<Integer> result){
        //base
        if(root == null) return;

        //logic
        if(depth == result.size()){
            result.add(root.val);
        }
        dfs(root.right, depth + 1, result);
        dfs(root.left, depth + 1, result);
    }
}

//TC-O(n)
 //SC-O(h)
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if(root == null) return result;
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           int size = q.size();
           for(int i=0;i<size;i++){
               TreeNode curr = q.poll();
               if(i == size-1){
                   result.add(curr.val);
               }
               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);
           }

       }

       return result;
    }
   
}
