//Tc: O(n)
//Sc: O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) 
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> children = new ArrayList<>();
            while(size > 0) {
                TreeNode node = q.remove();
                if(node.left != null)   
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                children.add(node.val);
                size--;
            }
            res.add(children.get(children.size()-1));
        }
        return res;
    }
}