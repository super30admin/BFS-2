import java.util.LinkedList;
import java.util.Queue;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Cousin {
    public static void main(String[] args) {
        //[1,2,3,null,4,null,5]
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=null;
        root.left.right=new TreeNode(4);
        root.right.left=null;
        root.right.right=new TreeNode(5);


        isCousins(root,4,5);
    }
    public static boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Queue<TreeNode> q=new LinkedList();


        q.add(root);
        while(!q.isEmpty()){
            boolean xFound=false;
            boolean yFound=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.val==x){
                    xFound=true;
                }
                if(cur.val==y){
                    yFound=true;
                }

                if(cur.left!=null && cur.right!=null){
                    if(cur.left.val==x && cur.right.val==y || cur.left.val==y && cur.right.val==x){
                        return false;
                    }
                }

                    if(cur.left!=null)
                        q.add(cur.left);
                    if(cur.right!=null)
                        q.add(cur.right);


               if(xFound && yFound)return true;
            }
        }


        return false;
    }
       // return false;  }
}