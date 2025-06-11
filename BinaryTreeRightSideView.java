//Solved successfully on leetcode and faced no issues.
//TC : O(n) SC : O(n)

class Solution {
    //DFS Approach
    public List<Integer> rightSideView(TreeNode root){
        List<Integer>output = new ArrayList<>();
        dfs(root , 0 , output);
        return output;
    }
    private void dfs(TreeNode root , int currentlevel , List<Integer>output){
        if(root == null){return;}
        if(output.size() == currentlevel){
            output.add(root.val);
        }
        dfs(root.right , currentlevel+1 , output);
        dfs(root.left , currentlevel+1 , output);


    }
}
    //BFS Approach
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer>output = new ArrayList<>();
    //     if(root == null){
    //         return output;
    //     }
    //     Queue<TreeNode>queue = new LinkedList<>();
    //     //Insert root into queue
    //     queue.add(root);
    //     //start our BFS
    //     while(!queue.isEmpty()){
    //         int queuesize = queue.size();
    //         List<Integer>currentlevel = new ArrayList<>();
    //         //Do something : storing last element in every queue to output list
    //         for(int i = 0 ; i < queuesize ; i++){
    //             TreeNode cnode = queue.remove();
    //             if(i == queuesize-1){
    //                 output.add(cnode.val);
    //             }
    //             //process its children
    //             if(cnode.left!=null){
    //                 queue.add(cnode.left);
    //             }
    //             if(cnode.right!=null){
    //                 queue.add(cnode.right);
    //             }
    //         }
    //     }
    //     return output;        
        
    // }
