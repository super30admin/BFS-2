import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Rightsideview {
       public IList<int> RightSideView(TreeNode root) {
        Queue<TreeNode> queue
            = new Queue<TreeNode>();
        List<int> result = new List<int>();
        int check=0;
        if (root==null)
            return result;
        queue.Enqueue(root);
        while(queue.Count()>0)
        {
            int size = queue.Count();
            List<int> temp = new List<int>();
            for(int i=0;i<size;i++)
            {
                TreeNode currNode = queue.Dequeue();
                if(i==size-1)
                result.Add(currNode.val);
                if(currNode.left!=null)
                {
                    queue.Enqueue(currNode.left);
                }
                if(currNode.right!=null)
                {
                    queue.Enqueue(currNode.right);
                }
            }
        }
        return result;
    }
}
