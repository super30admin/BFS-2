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
time : O(n);
Space:O(n);

class Solution {
    List<Integer> li=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue <TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();

            List <Integer> li2=new ArrayList<Integer>();

            for(int i=0;i<size;i++){
                TreeNode temp= q.poll();
                if(li2.size()==0){
                    li2.add(temp.val);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
            }
            li.add(li2.get(0));
        }
        System.out.println(li);
        return li;

    }

}