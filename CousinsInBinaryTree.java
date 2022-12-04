import java.util.LinkedList;
import java.util.Queue;
/*Requirement - We need 2 children to be of different parents at same level so they can be called as cousins
* DFS Approach
* Steps - Declare parents as we need to track the parents of the children
* Traverse level by level and if the value of x or y is equal to current root value update the results.
* Once x,y is found check the match of their parents and return appropriate answer
* Time Complexity -O(n) - number of nodes
* Space Complexity - O(h) - height of the tree
*
* BFS Approach
* Steps - Initialize a queue to store the current elements
* Initialize size to keep track of level
* check if current val equals x or y and update xFound, yFound values
* Main issue which I faced was to keep track of parents - we resolve it by just checking whether a parent has
* 2 children or not.
* Time Complexity - O(n)
* Space Complexity - O(n) - the queue space.
* 
* */
//https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsInBinaryTree {
    //DFS solution
    /*TreeNode xParent,yParent;
    int xLvl,yLvl;
    public boolean isCousins(TreeNode root, int x, int y){
    if(root==null) return false;
    dfs(root,x,y,0,null);
    return xLvl==yLvl && xParent==yParent;

    }
    private void dfs(TreeNode root,int x, int y, int lvl, TreeNode parent){
        if(root==null) return;
        if(root.val==x){
            xLvl=lvl;
            xParent=root;
        }
        if(root.val==y){
            yLvl=lvl;
            yParent=root;
        }
        if(xParent==null || yParent==null) {
            dfs(root.left, x, y, lvl + 1, root);
            dfs(root.right, x, y, lvl + 1, root);
        }
    }
*/
    //BFS Solution
    public boolean isCousins(TreeNode root, int x, int y){
        //base
        if(root==null)return false;
        //logic
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.val==x) xFound=true;
                if(curr.val==y) yFound=true;
                if(curr.left!=null && curr.right!=null) {
                    if (curr.left.val == x && curr.right.val == y) return false;
                    if (curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }
            if(xFound==true && yFound==true) return true;
            if(xFound==true || yFound==true) return false;
        }
        return true;
    }



    //BFS Try
   /* public boolean isCousins(TreeNode root, int x, int y) {
        int firstElement = 0;
        int secondElement = 0;
        if(root==null) return  false;
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int counter =0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(!map.containsKey(root.val)) map.put(root.val,counter);

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            counter++;
        }
        firstElement=map.get(x);
        secondElement= map.get(y);
        if(firstElement!=0 &&secondElement!=0 && firstElement==secondElement) return true;
        return false;

    }*/


}
