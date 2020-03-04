// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeCousinsPassed {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        TreeNode parentx=null,parenty=null;
        int levelx=-1,levely=-1;
        Queue <TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level =  0;
        while(!q.isEmpty()){
            int count = q.size();
            for(int i= 0;i<count;i++){
                TreeNode current = q.poll();
                if(current.left!=null){
                    if(current.left.val==x){
                        parentx = current;
                        levelx=level;
                    }
                    else if(current.left.val ==y){
                        parenty=current;
                        levely=level;
                    }
                    q.add(current.left);
                }
                if(current.right!=null){
                    if(current.right.val==x){
                        parentx = current;
                        levelx=level;
                    }
                    else if(current.right.val ==y){
                        parenty=current;
                        levely=level;
                    }
                    q.add(current.right);
                }
            }
            level++;
        }
        return (levelx==levely)&&(parentx!=parenty);
    }
}
