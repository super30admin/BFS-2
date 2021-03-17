//Time complexity:O(n)
//Space complexity: O(height of tree)
//Executed on leet code

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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {        
        /*if(root==null)
            return list;
        List<TreeNode> li = new ArrayList<>();
        li.add(root);
        bfs(li);        
        return list;*/
        if(root==null)
            return list;        // This code has both DFS and BFS approach.
        dfs(root, 0);
        return list;            //Storing each level subtrees in a list and returing the value of last treenode root value to the list. So, returns allright values.(BFS)
    }
    
    /*void bfs(List<TreeNode> li)
    {
        if(li.size()==0)        //
            return;
        
        list.add(li.get(li.size()-1).val);
        
        List<TreeNode> temp = new ArrayList<>();
        for(TreeNode l:li)
        {
            if(l.left!=null)
                temp.add(l.left);
            if(l.right!=null)
                temp.add(l.right);
        }
        bfs(temp);          //Following similar approach traversing all the way to left bottom and storing the each levels right value to list.
    
        
    }*/
    
    void dfs(TreeNode root, int h)
    {
        if(root==null)
            return;
        if(list.size()==h)
            list.add(root.val);
        else
            list.set(h,root.val);
        dfs(root.left,h+1);
        dfs(root.right, h+1);
    }
}