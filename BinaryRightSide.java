 //dfs solution
 // traversal which starts adding elements from the right
 // add the root 
 // going to the right check if the node exists at the level
 // if not add it, else move to the next recursive pattern

 //TC: O(n)
 //SC: O(h)
// works on leetcode

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level)
    {
        if(root == null) return;

        //logic
        if(level == result.size()){
            result.add(root.val);
        }

        //dfs
        dfs(root.right, level +1);
        dfs(root.left, level+1);
    }
}
 
// bfs solution
// travese the tree in level order
// pick the last element and it to the result array
// TC: O(n)
// SC: O(n)







