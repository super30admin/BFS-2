// Time complexity O(n) - n is number of nodes
//Space complexity O(h) - nodes at last level of the tree

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        // flags if node values match x/y
        boolean flagX = false; 
        boolean flagY = false;
        //null case
        if(root == null) return false;
        if(root.val == x || root.val == y) return false;
        q.add(root);
        while(!q.isEmpty()){
            size = q.size();
            //resetting flags to flase after current level is traversed
            flagX = false;
            flagY = false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
            if(curr.left != null && curr.right != null){
                if((curr.left.val == x && curr.right.val == y) || (curr.right.val == x && curr.left.val == y)) {return false;}
            }
            if(curr.left != null){
                q.add(curr.left);
                if(curr.left.val == x) flagX = true;
                if(curr.left.val == y) flagY = true;
            }
            if(curr.right != null){
                q.add(curr.right);
                if(curr.right.val == x) flagX = true;
                if(curr.right.val == y) flagY = true;
            }
                
            }
            if(flagX && flagY) return true;
            
            
        }
        return false;
        
    }
}