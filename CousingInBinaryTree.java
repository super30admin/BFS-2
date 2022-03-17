/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {

//     private TreeNode xParent , yParent;
//     private int xLevel, yLevel;
//     private int x, y;

//     public boolean isCousins(TreeNode root, int x, int y) {

//         xParent = yParent = null;
//         this.x = x;
//         this.y = y;
//         isCousins(root, null, 0);
//         return xLevel==yLevel && xParent != yParent;

//     }

//     private  void isCousins(TreeNode root , TreeNode parent , int level)
//     {

//         if(root == null )
//         {
//             return;
//         }

//             if(root.val == x)
//             {
//                 xLevel = level;
//                 xParent = parent;

//             }

//           if(root.val == y)
//             {
//                 yLevel = level;
//                 yParent = parent;

//             }

//         isCousins(root.left, root, level+1);
//         isCousins(root.right , root , level+1);
//     }
// }


//using BFS
//
class Pair{
    private TreeNode curr;
    private int parent;

    Pair(TreeNode curr , int parent)
    {
        this.curr = curr;
        this.parent = parent;
    }

    public TreeNode getCurr(){return curr;}
    public int getParent(){return parent;}
}
class Solution{

    public boolean isCousins(TreeNode root , int x , int y)
    {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root , 0));

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean foundX = false, foundY= false;

            int parentX = 0 , parentY = 0;
            for(int i = 0 ; i <size ; ++i)
            {
                Pair p = q.remove();
                TreeNode curr = p.getCurr();


                //process
                if(curr.val == x)
                {
                    foundX = true;
                    parentX= p.getParent();
                }

                if(curr.val == y)
                {
                    foundY = true;
                    parentY= p.getParent();
                }

                //add left
                if(curr.left != null)
                    q.add(new Pair(curr.left, curr.val));

                //add right

                if(curr.right != null)
                    q.add(new Pair(curr.right, curr.val));
            }

            //if both found , then just verify that parents not same
            if(foundX && foundY)
            {
                return parentX != parentY;
            }

            if(foundX || foundY)
            {
                return false;
            }

            if(foundX && foundY)
            {
                break;
            }

        }
        return false;
    }
}