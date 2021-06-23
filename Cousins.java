/*TC - O(N) SC O(N)*/

public class QueueNode {
    TreeNode current ; 
    TreeNode parent;
    QueueNode( TreeNode curr, TreeNode par) {
          this.current = curr;
          this.parent = par;
      }
    
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // level order traversal of tree + save the level, if its different, then cousins , else false
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
       
        queue.add(new Pair<>(root, null));
        int level = 0 ; 
        int first = Integer.MAX_VALUE ;
        int second = Integer.MIN_VALUE;
        int fParent = Integer.MAX_VALUE;
        int sParent = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size; i++){
                Pair<TreeNode, TreeNode> elem = queue.poll();
                TreeNode current = elem.getKey();
                TreeNode parent = elem.getValue();
                if (parent != null && current.val == x){
                    first = level;
                    fParent = parent.val;
                }
                //TreeNode current = e
                if (parent != null && current.val == y){
                    second = level;
                    sParent = parent.val;
                }
                
                
                if (current.left != null){
                    queue.add(new Pair<>(current.left, current));
                }
                if (current.right != null){
                    queue.add(new Pair<>(current.right, current));
                }
            }
            level +=1 ;
        }
     
        //true if the levels are same and both have different parents then they are cousins
        return ( (second == first && fParent!=sParent) );
    
        
    }
}



