// BFS solution 

// Time complexity: O(N)
// Space complexity: O(W)
// Run on Leetcode: Yes
// Issues faced: None

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) 
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                if(i == size-1)
                    res.add(node.val);
            }
        }
        return res;
    }
}

// DFS solution

// Time complexity: O(N)
// Space complexity: O(H)
// Run on Leetcode: Yes
// Issues faced: None

class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList<>();
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null)
            return;
        
        //logic
        if(res.size() == level)
            res.add(root.val);
        
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}
