Time Complexity: O(n)
Space Complexity: O(n) // at max the width of the tree
*/

class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
    Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            // each level
            boolean xFound = false, yFound = false;

            // for loop to go over the elements at each level
            for(int i=0; i < size; i++){
                TreeNode cur = q.poll();

                if(cur.val == x) xFound = true;
                if(cur.val == y) yFound = true;

                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y) return false;
                    if(cur.left.val == y && cur.right.val == x) return false;
                }

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            if(xFound && yFound)
                return true;
        }
        return false;
    }
}