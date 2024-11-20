/*
 * Tc - o(n)
 * SC - O(n)
 * Approach - we check if the size is equal to depth, if so then we are adding to the 
 * result, or else we update the value at that depth in the result list
 */

public class RightSideView {
    //dfs
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int depth){
        //base 
        if(root == null) return;

        //logic 
        if(depth == result.size()){
            result.add(root.val);
        }else{
            result.set(depth, root.val);
        }

        //recurse 
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }

    //bfs
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     if(root == null) return result;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         for(int i = 0; i < size; i++){
    //             TreeNode curr = q.poll();
    //             if(i == size-1){ //if we change this to i == 0 then it is left side tree
    //                 result.add(curr.val);
    //             }
    //             if(curr.left != null) q.offer(curr.left);
    //             if(curr.right != null) q.offer(curr.right);
    //         }


    //     }

    //     return result;
    // }
}
