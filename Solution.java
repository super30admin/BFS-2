import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {

    boolean flag= false;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> parentQueue = new LinkedList<>();
    queue.add(root);
    parentQueue.add(null);

    while(!queue.isEmpty()){

      int size= queue.size();
      int count=0;
      TreeNode parent= null;
      while(size>0){

        TreeNode temp = queue.poll();
        TreeNode tempParent = parentQueue.poll();

        if(temp.left != null){
          queue.add(temp.left);
          parentQueue.add(temp);
        }

        if(temp.right != null){
          queue.add(temp.right);
          parentQueue.add(temp);
        }

        if((temp.val==x || temp.val==y) && parent != tempParent){
          count ++;
          parent = tempParent;
        }

        size--;
      }

      if(count==2){
        return true;
      }
    }

    return flag;

  }
}