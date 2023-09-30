//Time complexity:O(n)
//Space complexity:O(n) 
//Solved steps:at intial we add root element
//Here we use queue to store the elements and as we travel till queue is empty
//curr=get from queue and check if its last element :true then store in result 
//then check the left node and right node if not null 
//and keep adding in queue ,then add the values addded in temp to result 
//and return result
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

        }
        }
        return result;
    }
}