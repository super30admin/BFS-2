class Problem1{
public List<Integer> rightSideView(TreeNode root) {
    //Time complexity- O(n)
    //Space complexity - O(n)

     Queue<TreeNode> q = new LinkedList<>();
     List<Integer> result = new ArrayList<>();

     //Base Case:
     if (root == null) return result;

     q.offer(root);

     while(!q.isEmpty()){
         int size = q.size();

         for(int i = 0; i<size;i++){
             TreeNode current = q.poll(); //Pop the current element of the queue
             //Add last element in the result
             if(i == size-1){
                 result.add(current.val);
             }
         //Add babies of current node if exists 
         if(current.left != null) q.offer(current.left);
         if(current.right != null) q.offer(current.right);
         }
     } 
     return result;      
 }
}