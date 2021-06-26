

//Time Complexity: O(N)
//Space Complexity:O(H)



class Solution {
    int maxDepth = -1;
            List<Integer> result = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root,result,0);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result, int depth){
        if(root == null)return;
        
        if(depth > maxDepth){
            result.add(root.val);
            maxDepth =  depth;
        }
        helper(root.right, result, depth + 1);
        helper(root.left, result, depth + 1);
   
    }
    

}
