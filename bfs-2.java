//Q1: 690. Employee Importance

//Idea 1 : //graph between employee and sub ordinates ,just check if there isadj then add the reputatio and for reputation make hashmap and access it.

//Idea 2 and solution implementation : Use hashmap to store add id and employees list 
//use bfs i.e use queue to add all the id and poll and keep adding subordinates by looking up into map  and calculate the reputation

//O(N) - time ,O(1) to lookup from hashmap and add/remove from queue
//O(N) - space using map and queue

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int rep =0;
        //In hashmap add id and employees list 
        HashMap <Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        //for every id we'll add relevant subordinate and calculate the importance
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty()){
           Employee current = q.poll();
           rep += current.importance;
           for(int sub : current.subordinates){
               q.add(map.get(sub));
           }
        }
        return rep;
    }
}


//Q2: Cousins in binary tree

Q2 : cousins of binary tree

//Logic: check following conditions
//if depth of x = depth of y 
 //depth.ancestor != ancestor of y


 // Time Complexity : 0(N)
// Space Complexity :0(N)
class Solution {
    TreeNode xpar = null;
    TreeNode ypar = null;
    int xdepth = -1, ydepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        checkDepthAndParent(root,x,y,0,null);
        return xpar!=ypar && xdepth == ydepth ? true : false;
    }
    
     //get both the depth and parent for x and y
   public void checkDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
       if(root==null) return ;
       //if any given value is equal to root.val
       if(root.val == x){
           xpar = parent;
           xdepth = depth;
       }else if (root.val == y){
           ypar = parent;
           ydepth = depth;
       }
       checkDepthAndParent(root.left, x, y, depth + 1, root);
       checkDepthAndParent(root.right, x, y, depth + 1, root);
    }
}


    
    
   
   
        
                                                                   
                                                                   

    
