//Time Complexity: O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully


//creating the pair class for BFS approach to store 2 values in a queue
class Pair{

    TreeNode node;
    int parent;

    Pair(TreeNode node, int parent){
        this.node = node;
        this.parent = parent;
    }

    public int getParent(){
        return parent;
    }

    public TreeNode getNode(){
        return node;
    }

}


public class CousinsInBinaryTree993LeetCode {

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


        //DFS Approach
        TreeNode parentX, parentY;                  //creating the variable to store parent of X and Y
        int  levelX , levelY;                       //creating the variable to store level of X and Y
        int x,y;                                    // X and Y


        public boolean isCousins(TreeNode root, int x, int y) {

            parentX = null;                        //asssigning parentX and parentY to null and levelX and LevelY to -1
            parentY = null;
            levelX = -1;
            levelY= -1;
            this.x = x;
            this.y = y;

            cousins(root, null, 0);                //calling the DFS function with root and its parent which is null and its level which is zero

            return levelX == levelY && parentX != parentY;      //check if level of X and y are equal or not and if equal levels then check their parents are equal or not
        }

        public void cousins(TreeNode node, TreeNode parent, int level){

            if(node == null){                       //if node is null then return
                return;
            }


            if(node.val == x){                      //if node value is X then assign parentX to parent and levelX to level and simply return from the function
                parentX = parent;
                levelX = level;
                return;
            }

            if(node.val == y){                   //if node value is Y then assign parentY to parent and levelY to level and simply return from the function
                parentY = parent;
                levelY= level;
                return;
            }


            cousins(node.left, node, level+1);      //calling function recursively with left child and parent which is current node and increament the level
            cousins(node.right, node, level+1);     //calling function recursively with right child and parent which is current node and increament the level
        }



        //BFS Approach 2
//     public boolean isCousins(TreeNode root, int x, int y) {

//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(root, -1));

//         while(!q.isEmpty()){

//             int size = q.size();
//             //System.out.println(q);
//             boolean foundX = false;
//             boolean foundY = false;
//             int parentX = 0;
//             int parentY = 0;

//             while(size>0){
//                 Pair p = q.remove();
//                 TreeNode node = p.getNode();
//                 int parent = p.getParent();
//                 //System.out.println(node.val);

//                 if(node.val == x){
//                     foundX = true;
//                     parentX = parent;
//                 }

//                 if(node.val == y){
//                     foundY = true;
//                     parentY = parent;
//                 }

//                 if(foundX && foundY){
//                     break;
//                 }


//                 if(node.left != null && node.right != null){

//                     if( node.left.val == x && node.right.val == y){
//                         return false;
//                     }
//                     if( node.left.val == y && node.right.val == x){
//                         return false;
//                     }
//                 }


//                 if(node.left != null){
//                     q.add(new Pair(node.left, node.val));
//                 }

//                 if(node.right != null){
//                     q.add(new Pair(node.right, node.val));
//                 }
//                 size--;


//             }
//             if(foundX && foundY){
//                 return parentX != parentY;
//             }
//             if(foundY || foundX){
//                 return false;
//             }

//         }
//         return false;
//     }








        //BFS Approach 1
//     public boolean isCousins(TreeNode root, int x, int y) {

//         Queue<TreeNode> q = new LinkedList<>();

//         boolean xFound = false;
//         boolean yFound = false;

//         q.add(root);

//         while(!q.isEmpty()){

//             int size = q.size();
//             //System.out.println(q);

//             while(size>0){

//                 TreeNode node = q.remove();
//                 //System.out.println(node.val);

//                 if(node.val == x){
//                     xFound = true;
//                 }

//                 if(node.val == y){
//                     yFound = true;
//                 }

//                 if(node.left != null ){
//                     if(node.right != null){
//                         if( node.left.val == x && node.right.val == y){
//                             return false;
//                         }
//                         else if( node.left.val == y && node.right.val == x){
//                             return false;
//                         }
//                     }
//                     q.add(node.left);
//                 }
//                 if(node.right != null){
//                     q.add(node.right);
//                 }
//                 size--;


//             }
//             if(xFound && yFound){
//                 return true;
//             }
//             if(xFound || yFound){
//                 return false;
//             }

//         }
//         return false;
//     }

}
