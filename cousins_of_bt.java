//T.C- O(N)- in worst case we might have to visit all nodes 
//T.C-O(N)- space utilized by the queue
import java.util.ArrayList;
import java.util.LinkedList;

//   Definition for a binary tree node.
  public class cousins_of_bt {
      int val;
      cousins_of_bt left;
      cousins_of_bt right;
      cousins_of_bt() {}
      cousins_of_bt(int val) { this.val = val; }
      cousins_of_bt(int val, cousins_of_bt left, cousins_of_bt right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {
    public boolean isCousins(cousins_of_bt root, int x, int y) {
        if(root==null){
            return false;
        }
        LinkedList<cousins_of_bt> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            ArrayList<Integer>level= new ArrayList<>();
            for(int i=0; i< size;i++){
                cousins_of_bt temp=queue.remove();
                if(temp.left!=null && temp.right!=null){
                    if(temp.left.val==x && temp.right.val==y){
                        return false;
                    }
                    if(temp.right.val==x && temp.left.val==y){
                        return false;
                    }
                }
                level.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            if(level.contains(x) && level.contains(y)){
                return true;
            }
            
        }
        return false;
        
    }
}