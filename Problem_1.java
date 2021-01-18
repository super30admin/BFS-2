// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Here I took a global variable maxlevel and also the list as the global variable.
//while recursing if I find that the level is greater than or equal o maxLevel then I enter the data into the list and also increase the max level.

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
    List<Integer> li;
    int maxLevel;
    public List<Integer> rightSideView(TreeNode root) {
        li=new ArrayList<Integer>();
        maxLevel=1;
        findRightSideView(root,1);
        return li;
    }
    public void findRightSideView(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level>=maxLevel){
            li.add(root.val);
            maxLevel=maxLevel+1;
        }
        findRightSideView(root.right,level+1);
        findRightSideView(root.left,level+1);
    }
}

// Time Complexity :O(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
//Here I take a treemap and then store the list of elements level wise.
//The I iterate through the map an put the first elements of the list into the map.
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
    TreeMap<Integer,List<Integer>> tree;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        if(root==null){
            return li;
        }
        tree=new TreeMap<Integer,List<Integer>>();
        findRightSideView(root,1);
        //System.out.println(tree);
        for(int i:tree.keySet()){
            li.add(tree.get(i).get(0));
        }
        return li;
    }
    public void findRightSideView(TreeNode root,int level){
        if(root==null){
            return;
        }
       if(tree.containsKey(level)){
           tree.get(level).add(root.val);
       }else{
           List<Integer> list=new ArrayList<>();
           list.add(root.val);
           tree.put(level,list);
       }
        findRightSideView(root.right,level+1);
        findRightSideView(root.left,level+1);
    }
}