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
class TreeCousinsv1 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return false;
        }
        if ((root.left.val == x && root.right.val == y)||(root.left.val == y && root.right.val == x)){
            return false;
        }
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> sublist =  new LinkedList<Integer>();
            TreeNode current = q.peek();
            for(int i = 0; i<level;i++){
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }
                sublist.add(q.poll().val);
            }
            for(int i = 0;i<sublist.size();i++){
                if(sublist.get(i)==x || sublist.get(i)==y){
                    if(sublist.get(i)==x){
                        for(int j = i+2;j<sublist.size();j++){
                            if(sublist.get(j)==y){
                                return true;
                            }
                        }
                    }
                    if(sublist.get(i)==y){
                        for(int j = i+2;j<sublist.size();j++){
                            if(sublist.get(j)==x){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
