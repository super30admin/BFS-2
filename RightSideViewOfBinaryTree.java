import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBinaryTree {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        
        //dfs(root,0);
        bfs(root);
        return result;
    }
     // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes
    


    public void dfs(TreeNode root,int level)
    {
        if(root==null)return;
        if(result.size()==level)
        {
            result.add(root.val);
            
        }
        else {
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes

    public void bfs(TreeNode root)
    {
       if(root==null)
           return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //because you're getting last node of each level so maintaining level is important
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(i==size-1)
                    result.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                
            }
        }
    }
}
