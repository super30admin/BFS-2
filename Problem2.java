

//Time: O(N)
//Space: O(N)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(checkSameLevel(root, x, y) && !checkSiblings(root, x, y)) return true;
        return false;
    }
    
    public boolean checkSameLevel(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Set<Integer> s = new HashSet<Integer>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(!q.isEmpty()){
                    q.add(null);
                    if(s.contains(x) && s.contains(y)) return true;
                    s = new HashSet<Integer>();    
                }
            }
            else{
                if(curr.left != null){
                    q.add(curr.left);
                    s.add(curr.left.val);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    s.add(curr.right.val);
                }
            }
        }
        return false;
    }
    
    public boolean checkSiblings(TreeNode root, int a, int b){
        if(root == null) return false;
        
        if(root.left != null && root.right != null){
            if((root.left.val == a && root.right.val == b) || (root.left.val == b && root.right.val == a)) 
                return true;    
        }
        
        return (checkSiblings(root.left, a,b) || checkSiblings(root.right, a, b));
    }
}
