// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, -1));
        while(!q.isEmpty()){
            int size = q.size();
            int pX = -1;
            int pY = -1;
            for(int i = 0; i < size;i++){
                Pair<TreeNode, Integer> front = q.poll();
                TreeNode node = front.getKey();
                int parent = front.getValue();
                if(node.val == x ){
                    pX = parent;
                }
                if(node.val == y ){
                    pY = parent;
                }
                if(node.left != null)
                    q.add(new Pair<>(node.left, node.val));
                if(node.right != null)
                    q.add(new Pair<>(node.right, node.val));
            }
            if(pX != -1 && pY != -1){
                 if(pX == pY){
                     return false;
                 }else
                     return true;
            }
            if(pX != -1 || pY != -1)
                return false;
        }
        return false;
    }
}
