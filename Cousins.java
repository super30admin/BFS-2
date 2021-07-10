
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public boolean isCousins(TreeNode root, int x, int y) {
        //edge case 
        if(root.val == x || root.val == y) return false;
        Queue<TreeNode> bfs = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        map.put(x,new ArrayList<>());
        map.put(y,new ArrayList<>());
        bfs.add(root);
        bfs.add(null); //parent
        int level =0;
        while(!bfs.isEmpty())
        {
            int size= bfs.size()/2;
            for(int i = 0 ; i <size;i++)
            {
                TreeNode node = bfs.poll();
                TreeNode parent = bfs.poll();
                if(node.val==x)
                {
                    map.get(x).add(level);
                    map.get(x).add(parent.val);
                }
                if(node.val==y)
                {
                    map.get(y).add(level);
                    map.get(y).add(parent.val);
                }
                if(node.left!=null) 
                {
                    bfs.add(node.left);
                    bfs.add(node); //parent
                }
                if(node.right!=null) 
                {
                    bfs.add(node.right);
                    bfs.add(node); //parent
                }
            }
            level++;
        }
        if(map.get(x).get(0)==map.get(y).get(0))
        {
            return map.get(x).get(1)!=map.get(y).get(1);
        }
        return false;
            
    }
}