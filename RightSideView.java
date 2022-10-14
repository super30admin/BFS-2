//Recursive Approach

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }
    
    public void rightView(TreeNode root, int level, List<Integer> result){
        //base case
        if(root == null)
            return;
        if(level == result.size())
            result.add(root.val);
        rightView(root.right, level+1, result);
        rightView(root.left, level+1, result);
    }
}

//Time Complexity :O(n)
//Space Complexity :O(n)