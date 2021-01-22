// Time Complexity : 0(N)
// Space Complexity : 0(N) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't think about DFS approach

//BFS Solution
class Right View {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList();

        //BFS - do level order traversal and add last element of each level in result

        //queue for level order traversal
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()){
            int size = queue.size();

            while (size -- > 0){
                TreeNode cur = queue.poll();
                //add last element of every level to result
                if (size == 0)
                    res.add(cur.val);

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return res;
    }
}

//DFS Solution
class RightView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        if(root == null)
            return;
        //if new level reached, add root val to result
        if(level == result.size())
            result.add(root.val);
            //else replace existing value in result at that level
        else
            result.set(level, root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

//DFS Solution
