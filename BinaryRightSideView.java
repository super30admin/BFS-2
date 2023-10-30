// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
           
//BFS
 public List<Integer> rightSideView(TreeNode root) {
  
        <Integer> list=new ArrayList<>();
              if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                 TreeNode curr=q.poll();
                if(i==size-1){
                    list.add(curr.val);
                }
               
            
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

            }
           
        }
        return list;
    }
}

//DFS

//  List<Integer> list;
//     public List<Integer> rightSideView(TreeNode root) {
//         this.list=new ArrayList<>();
//         helper(root,0);
//         return list;
//     }
//     public void helper(TreeNode root,int level){
//         //base
//         if(root==null)return;

//         //logic
//         if(level==list.size()){
//             list.add(root.val);
//         }
//         helper(root.right,level+1);
//         helper(root.left,level+1);
//     }
