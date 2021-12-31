//Space Complexity:O(H)
//Time Complexity:O(N)
import java.util.*;

public class RightSideView{
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList<>();
        if(root==null) return res;
        helperdfs(root,0);
        return res;
        }
        void helperdfs(TreeNode root,int lvl){
            if(root==null) return ;
            if(res.size()==lvl){
                res.add(root.val);
            }
            else{
                res.set(lvl,root.val);
            }
            helperdfs(root.left,lvl+1);
            helperdfs(root.right,lvl+1);
            
            
        }
}
