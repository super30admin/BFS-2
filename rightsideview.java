package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightsideview {
	 public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> visiblevalues= new ArrayList<Integer>();
	        if(root == null){
	            return visiblevalues;
	        }
	        Queue<TreeNode> que= new LinkedList<>();
	        que.add(root);
	        while(!que.isEmpty()){
	            int size= que.size();
	            System.out.println(que.size());
	            for(int i=0;i<size;i++){
	                TreeNode current= que.poll();
	                if(i==size-1){
	                    visiblevalues.add(current.val);
	                }
	                if(current.left !=null){
	                    que.add(current.left);
	                }
	                 if(current.right !=null){
	                    que.add(current.right);
	                }
	            }
	        }
	        return visiblevalues;
	    }

}
