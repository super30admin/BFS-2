
//Time complexity: O(N), where N is the number of nodes in the tree
//Space complexity: O(M), where M is the maximum width of the tree

//we use BFS to traverse the tree level by level instead of maintaing a data structure for parent pointers 
//we check whether x and y are siblings before processing if they are siblings return false
//if we find both x and y in the same level we return true
//if we find either x or y in the next level we return false

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean x_found=false,y_found=false;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();

                //checking if x and y are siblings
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.right.val==x && curr.left.val==y) return false;
                }
                if(curr.val==x){
                    x_found=true;
                }else if(curr.val==y){
                    y_found=true;
                }
                //traverse left and right children
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            if(x_found && y_found) 
                return true;  
            if(x_found || y_found) 
                return false;
        }
        return true;
    }
}