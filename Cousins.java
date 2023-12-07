import java.util.LinkedList;
import java.util.Queue;

class Cousins {
  public boolean isCousins(TreeNode root, int x, int y) {

    boolean flag= false;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

      int size= queue.size();
      int count=0;
      while(size>0){

        TreeNode temp = queue.poll();

        if(temp.left != null && temp.right != null){
          if(temp.left.val==x && temp.right.val==y) return false;
          if(temp.left.val==y && temp.right.val==x) return false;
        }

        if(temp.left != null){
          queue.add(temp.left);
        }

        if(temp.right != null){
          queue.add(temp.right);
        }

        if((temp.val==x || temp.val==y)){
          count ++;
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