//Time Complexity: O(n)
//Space Complexity: O(n)
//Ran in Leetcoode: yes

//Vist all the child nodes at each level and add to the result whihc is a BFS 
//check sthe parent queue when x_found and y_found

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
      if(root == null) return false;
      Queue<TreeNode> queue = new LinkedList<>();
      Queue<TreeNode> pq = new LinkedList<>();
       TreeNode x_parent=null;
       TreeNode y_parent=null;
      queue.add(root);
      while(!queue.isEmpty()){
        int size = queue.size();
            boolean x_found = false;  
            boolean y_found = false;
        for(int i=0;i<size;i++){
            TreeNode curr = queue.poll();
             TreeNode currP = pq.poll();
            if(curr.val == x){
                x_found = true;
                x_parent = currP;
            }
            if( curr.left != null){
                queue.add(curr.left);
                pq.add(curr);
            }
            if(curr.val == y){
                y_found = true;
                y_parent = currP;
            }
            if( curr.right != null){
                queue.add(curr.right);
                pq.add(curr);
            }
        }
        if(x_found && y_found) return y_parent != x_parent;
      }
      return false;
    }
}