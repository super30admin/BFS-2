
class Solution {

// Time Complexity: O(n)
//  Space Complexity: O(n) 
// BFS Traversal
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(root);
        while(queue.size() != 0){
            int len = queue.size();
            TreeNode node = null;
            for(int i=1; i<= len; i++ ){
                node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
        
    }


// Time Complexity: O(n)
//  Space Complexity: O(h) 
// DFS Traversal (first right then left)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if(root == null) return list;
        helper(root, 0, list);
        return list;
        
    }

    private void helper(TreeNode root, int level, List<Integer> result){
        if(root == null) return;
        if(level == result.size()){
            result.add(root.val);
        }
        helper(root.right, level+1, result);
        helper(root.left, level+1, result);
    }



// Time Complexity: O(n)
//  Space Complexity: O(h) 
// DFS Traversal (first left then right)
     private void helper(TreeNode root, int level, List<Integer> result){
        if(root == null) return;
        if(level == result.size()){
            result.add(root.val);
        }else{
            result.set(level, root.val);
        }
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}