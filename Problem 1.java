// Time Complexity : O(n)
// Space Complexity : O(h) , where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*

We can do DFS from the root left to right

We will maintain an arrayList , the index of the array list is is the level, and we will overwrite the number at the levels if we going from left to right
as on right, last element will be
 */
class Solution {
    ArrayList<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<Integer>();
        dfsHelper(root,0);
        return list;
    }

    private void dfsHelper(TreeNode root,int level){

        //base case
        if(root == null){
            return;
        }

        // logic
        //check if level exists
        // ifnot make one and push root otherwise overwrite
        if(list.size() == level){ // that means it does not have this level
        list.add(root.val);
        }else{
            list.set(level,root.val); // overwrite with right most element
        }
        //recurse        
        dfsHelper(root.left,level+1);
        dfsHelper(root.right,level+1);
    }


}