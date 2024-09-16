// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
public class TreeCousinsFailedAttempt {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        HashMap<Integer,TreeNode> xmap = new HashMap<Integer,TreeNode>();
        HashMap<Integer,TreeNode> ymap = new HashMap<Integer,TreeNode>();
        int xlevel,ylevel;
        TreeNode xparent=null,yparent=null;
        xmap = helper(x,root);
        ymap = helper(y,root);
        // xlevel = xmap.getKey();
        // xparent = xpair.getValue();
        // ylevel = ypair.getKey();
        // yparent = ypair.getValue();
        for (Map.Entry mapElement : xmap.entrySet()) {
            xlevel = mapElement.getKey();

            xparent = mapElement.getValue();
        }
        for (Map.Entry mapElement : ymap.entrySet()) {
            ylevel = mapElement.getKey();

            yparent = mapElement.getValue();
        }


        // System.out.println(xparent.val);
        // System.out.println(yparent.val);
        if((xlevel==ylevel)&&(xparent!=yparent)) return true;
        else return false;
    }
    public HashMap<Integer,TreeNode> helper(int val, TreeNode root){
        Queue<TreeNode> q =  new LinkedList<TreeNode>();
        int clevel =-1;
        int level;

        TreeNode parent;
        q.add(root);
        int flag=0;
        while(!q.isEmpty()){
            int levelcount = q.size();
            TreeNode currentNode = q.peek();
            for(int i = 0;i<levelcount;i++){
                if(currentNode.left!=null){

                    q.add(currentNode.left);
                    if(currentNode.left.val == val){
                        flag=1;
                        parent = currentNode;
                    }
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                    if(currentNode.right.val == val ){
                        flag=1;
                        parent = currentNode;

                    }
                }
                q.poll();
            }
            clevel++;
            if(flag==1){
                level = clevel;
                HashMap<Integer,TreeNode> res = new HashMap<Integer,TreeNode>();
                res.put(level,parent);
                return res;
            }

        }
    }
}
