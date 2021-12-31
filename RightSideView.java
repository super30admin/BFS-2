//Time Complexity: O(n)
//Space Complexity: O(n)

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int size;
        TreeNode current;
        int last=-1;
        while(!bfs.isEmpty()){
            size = bfs.size();
            for(int i=0;i<size;i++){
                current = bfs.remove();
                if(current.left!=null){
                    bfs.add(current.left);
                }
                if(current.right!=null){
                    bfs.add(current.right);
                }
                last = current.val;
            }
            result.add(last);
        }
        return result;
    }    
}
