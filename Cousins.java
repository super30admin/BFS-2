/**
 * The worst case time complexity is O(N) and the space complexity is O(N).
 * Here I created a custom class called info which stores the parent node and depth. When we encounter either x or y. We store the value
 * using hashmap and check if x.depth==y.depth and x.parent!=y.parent
 *
 * Yes, the code passed all the test cases in leetcode.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    public boolean isCousins(TreeNode root, int x, int y) {

        if(root==null){return false;}
        if(root.val==x || root.val==y){return false;}

        Queue<TreeNode> queue = new LinkedList<>(); HashMap<Integer,Info> map = new HashMap<>();
        queue.add(root);
        int depth = 0; int count = queue.size();

        while(queue.size()>0){

            TreeNode temp = queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
                if(temp.left.val==x || temp.left.val==y){
                    map.put(temp.left.val,new Info(temp,depth));
                }

                if(map.size()==2){
                    if(map.get(x).p!=map.get(y).p && map.get(x).depth==map.get(y).depth){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(temp.right.val==x || temp.right.val==y){
                    map.put(temp.right.val,new Info(temp,depth));
                }

                if(map.size()==2){
                    if(map.get(x).p!=map.get(y).p && map.get(x).depth==map.get(y).depth){
                        return true;
                    }
                    else{
                        return false;
                    }
                }

            }

            count--;
            if(count==0){
                depth++;
                count = queue.size();
            }
        }

        return false;
    }
}

class Info{
    TreeNode p;
    int depth;

    public Info(TreeNode p,int depth){
        this.p = p;
        this.depth = depth;
    }
}