import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> li= new LinkedList<>();
    if (root== null)return li;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

      int size= queue.size();

      while(size >0){

        TreeNode temp  = queue.poll();
        if(temp.left!= null){
          queue.add(temp.left);
        }
        if(temp.right!= null){
          queue.add(temp.right);
        }

        if(size==1){

          li.add(temp.val);
          size--;
        }
        else{
          size--;
        }
      }
    }
    return li;

  }
}