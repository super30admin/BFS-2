# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No




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
        if(root == null) return false;

        if(root.val == x || root.val == y) return false;
        TreeNode parentX = null, parentY = null;
        int levelX = -1, levelY = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()){
            int countNodeslevel = queue.size();
            for(int i = 0 ; i < countNodeslevel; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left != null){
                    if(currentNode.left.val == x){
                        parentX = currentNode;
                        levelX = depth;
                    }
                    else if(currentNode.left.val == y){
                        parentY = currentNode;
                        levelY = depth;
                    }

                    queue.add(currentNode.left);

                }


                if(currentNode.right != null){
                    if(currentNode.right.val == x){
                        parentX = currentNode;
                        levelX = depth;
                    }
                    else if(currentNode.right.val == y){
                        parentY = currentNode;
                        levelY = depth;
                    }

                    queue.add(currentNode.right);

                }
            }

            depth++;
        }


        if(parentX != parentY && levelX == levelY)
            return true;
        return false;


    }
}