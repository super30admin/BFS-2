
//T.C-O(N)
//S.c- O(D)- to keep queue where D is the tree diameter

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//   Definition for a binary tree node.
  public class rightview_bt {
      int val;
      rightview_bt left;
      rightview_bt right;
      rightview_bt() {}
      rightview_bt(int val) { this.val = val; }
      rightview_bt(int val, rightview_bt left, rightview_bt right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> rightSideView(rightview_bt root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<rightview_bt> queue = new LinkedList<rightview_bt>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            //System.out.println(size);
            for(int i=0;i<size;i++){
                rightview_bt node= queue.remove();
                if(i== size-1){
                    result.add(node.val);
                }
                if(node.left !=null){
                    queue.add(node.left);
                }
                if(node.right !=null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}