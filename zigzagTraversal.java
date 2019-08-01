//traversal through the array similar to ;evel order traversal except keeping a level count which reverses the string at odd levels
//Time:O(n)
//Space:O(n)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList();
        else{
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);
            int level = 0;
            while(!q.isEmpty())
            {
                int y = q.size();
                List<Integer> sub = new ArrayList();
                for(int i=0;i<y;i++){
                    TreeNode x = q.poll();
                    if(x.left!=null)
                        q.offer(x.left);
                    if(x.right!=null)
                        q.offer(x.right);
                    sub.add(x.val);
                }
                if(level%2==0)
                    result.add(sub);
                else
                {
                    Collections.reverse(sub);
                    result.add(sub);
                }
                level++;
                
                
                
            }
            return result;
        }
    }
}
