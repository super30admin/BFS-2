//Accepted on LT
//The idea is to do bfs and check before adding if they are siblings or not.
//If they are not siblings than check in 1 row that if the elemetns are present or not.
//Time should be O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelx =0 ;
        int levely=0 ;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode t = q.poll();
                if(t.val==x){
                    levelx = 1;
                }
                if(t.val==y){
                    levely = 1;
                }
                if((t.left!=null && t.left.val==x) && (t.right!=null&&t.right.val==y)){
                    return false;
                }
                if((t.left!=null && t.left.val==y) && (t.right!=null&&t.right.val==x)){
                    return false;
                }




                if(t.left!=null){
                    
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                
                
            }
            if(levelx!=0 && levely!=0){
                return true;
            }
            else if(levelx!=0 && levely==0){
                return false;
            }
            else if(levelx==0 && levely!=0){
                return false;
            }
        }
        return false;
        
    }

}