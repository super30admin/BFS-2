//time: O(N)
//space: O(N)


// Store curr node and its parent
class Pair{
     private int parent;
     private TreeNode curr;
     
     Pair(TreeNode curr, int parent) {
         this.curr = curr;
         this.parent = parent;
     }
     
     public TreeNode getCurr() {return curr;}
     public int getParent() {return parent;}
     
 }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<Pair> q = new LinkedList<>();
        //prent for root as 0
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean foundX= false, foundY=false;
            int xParent = 0, yParent = 0;
            for(int i=0;i<size; i++) {
                Pair p = q.remove();
                
                TreeNode curr = p.getCurr();
                
                //process
                //if x is current node, then get xParent
                if(x == curr.val) {
                    foundX= true;
                    xParent = p.getParent();
                }
                
                //if y is current node, then get yParent
                if(y == curr.val) {
                    foundY = true;
                    yParent = p.getParent();
                }
                
                //if both x and y found no need to process other nodes
                if(foundX && foundY)
                    break;
                
                //else process other nodes

                //process left node
                if(curr.left !=null)
                    q.add(new Pair(curr.left, curr.val));
                
                //process right node
                if(curr.right !=null)
                    q.add(new Pair(curr.right, curr.val));
            }
            
            //if both found, checck if different parents
            if(foundX && foundY) {
                return xParent != yParent;
            }
            
            //if either found or both not found, return false;
            if(foundX || foundY) {
                return false;
            }
        }
        return false;
    }
}