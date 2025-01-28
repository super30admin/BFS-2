public class Problem1 {

    bfs{
        //t.c -> o(n)
        //s.c -> o(n)
        List<Integer> ans;
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            ans = new ArrayList<>();
            bfs(root);
            return ans;
        }
        private void bfs(TreeNode root){
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i =0;i<size;i++){
                    TreeNode curr = q.poll();
                    //add only when at that level we're at the right most index
                    if(i == size-1){
                        ans.add(curr.val);
                    }
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
        dfs{

            //t.c -> o(n)
            //s.c -> o(h)
            List<Integer> ans;
            public List<Integer> rightSideView(TreeNode root) {
                if(root == null){
                    return new ArrayList<>();
                }
                ans = new ArrayList<>();
                dfs(root,0);
                return ans;
            }
            private void dfs(TreeNode root,int level){
                if(root == null){
                    return;
                }
                //now with each level increasing we're adding the element only when the level and size match in this case at each level only 1 element would be added
                if(level == ans.size()){
                    ans.add(root.val);
                }
                //need to go right first because at every level only 1 element is supposed to be added to ans
                dfs(root.right,level+1);
                dfs(root.left,level+1);

            }
        }
    }
}
