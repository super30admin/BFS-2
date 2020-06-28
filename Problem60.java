Execute in Leet code: Yes
time Complexity- o(n)
space complexity - o(n)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean foundx=false,foundy=false;
            int xpos=0,ypos=0;
            for(int i=0;i<size;i++){
              TreeNode cur = q.poll();
              if(cur!=null){
                  if((cur.left!=null && cur.left.val==x) || 
                    (cur.right!=null && cur.right.val==x)){
                      foundx=true;
                       if((cur.left!=null && cur.left.val==x))
                             xpos=2*i;
                        if((cur.right!=null && cur.right.val==x))
                             xpos=2*i+1;
                  }
                      
                  if((cur.left!=null && cur.left.val==y) || 
                    (cur.right!=null && cur.right.val==y)){
                     foundy=true;
                       if((cur.left!=null && cur.left.val==y))
                             ypos=2*i;
                        if((cur.right!=null && cur.right.val==y))
                             ypos=2*i+1;
                  }
                      
                  q.add(cur.left);
                  q.add(cur.right);   
              }
            }
            if(xpos-ypos==1 && xpos%2==1) return false;
            if(ypos-xpos==1 && ypos%2==1) return false;
            if(foundx&&foundy) return true;; 
        }
        return false;
    }
}
