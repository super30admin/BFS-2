import  java.util.*;

public class RightSideView {
    public class TreeNode {
        int val;
        RightSideView.TreeNode left;
        RightSideView.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        public List<Integer> rightSideViewBFS(TreeNode root) {
        /*
        Approach 1: Using BFS
        TC:O(n)
        SC:O(n)

        */
            List<Integer> result=new ArrayList<>();
            if(root==null) return result;
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


        List<Integer> result;
        public List<Integer> rightSideViewDFS(TreeNode root) {
        /*
        Approach 1: Using DFS
        TC:O(n)
        SC:O(n)

        */
            result=new ArrayList<>();
            if(root==null) return result;
            dfs(root,0);
            return result;
        }

        private void dfs(TreeNode root,int level){
            if(root==null){
                return;
            }

            if(result.size()==level){
                result.add(root.val);
            }
            dfs(root.right,level+1);
            dfs(root.left,level+1);
        }

}
