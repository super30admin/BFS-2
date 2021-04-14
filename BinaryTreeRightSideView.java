/**
 *
 *  Time Complexity: O(N) Where N is the number of nodes in the tree.
 *  Space Complexity: O(log(N)) Since in the worst case for BFS it would be the number of nodes in the lowest level which is N/2. When we use DFS it would take worst case O(N) and average log(N) stack space, where log(N) represents the height of the tree
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: In DFS we can do a pre-order traversal and travers to the right side of the tree first followed by left side of the tree. While doing the traversal we maintain the depth of the tree and a result array. For every element if the size of the result array is equal to the current depth of the node, that mean there is no element available at that depth so we add the current node value. Else we simply travers to the next element in DFS. 
 */
class Solution {
    
    //DFS: 
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result= new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        if(root==null) return;
        if(result.size()==depth){
            result.add(root.val);
        }
        if(root.right!=null) dfs(root.right,depth+1);
        if(root.left!=null) dfs(root.left,depth+1);
    }
    
    //BFS:
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     if(root==null) return result;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while(    //         int size = queue.size();
    //         TreeNode last=null;
    //         while(size>0){
    //             last=queue.poll();
    //             if(last.left!=null) queue.offer(last.left);
    //             if(last.right!=null) queue.offer(last.right);
    //             size--;
    //         }
    //         result.add(last.val);
    //     }
    //     return result;
    //  }
    
    
    
}
