// ## Problem 1

// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

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
    //1. BFS
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    private List<Integer> bfs(TreeNode root){
        if(root==null)  return new ArrayList<>();

        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int size_n=q.size();

            // Process the level
            for(int i=0;i<size_n;i++){
                TreeNode curr=q.poll();

                // Check if last node in level
                if(i==(size_n-1)){
                    res.add(curr.val);
                }

                if(curr.left!=null){
                    q.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }

        return res;
    }

    private void dfsHelper1(TreeNode root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        if(result.size()<=level){
            result.add(root.val);
        }
        dfsHelper1(root.right, level+1, result);
        dfsHelper1(root.left, level+1, result);
    }

    //2. DFS with right side traversed first
    // Time - O(N)
    // Space - O(H)
    private List<Integer> dfsWithList1(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        dfsHelper1(root,0,result);
        return result;
    }

    private void dfsHelper2(TreeNode root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        if(result.size()<=level){
            result.add(root.val);
        }
        result.set(level, root.val);
        dfsHelper2(root.left, level+1, result);
        dfsHelper2(root.right, level+1, result);
    }

    //3. DFS with left side traversed first
    // Time - O(N)
    // Space - O(H)
    private List<Integer> dfsWithList2(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        dfsHelper2(root,0,result);
        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        //1. BFS
        //return bfs(root);
        //2. DFS - Right side first
        //return dfsWithList(root);
        //3. DFS - Left side first
        return dfsWithList2(root);
    }
}