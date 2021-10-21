//Timecomplexity:-O(n) for traversing all nodes.
// space complexity:;O(n)
//Did it work on leetcode=yes.
//What problems did you face?:- got wrong answers initially .
//Your code with explanation:- as we need to print first right nodes one level after other it is bfs and calling rightside first .





class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output=new ArrayList<>();
        int h=0;
        levelright(root,h,output);
        
    return output;}
    private void levelright(TreeNode root,int h, List<Integer> output){
        if(root==null){
            return ;
        }
        if(h==output.size()){
            output.add(root.val);
        }
        levelright(root.right,h+1,output);
        levelright(root.left,h+1,output);
    }
}