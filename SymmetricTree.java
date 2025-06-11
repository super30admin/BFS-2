//Time Complexity: O(n)
//Space Complexity: O(h)

//Using DFS - Boolean based recursion approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null)
            return true;
        //lofic
        if(left == null || right == null || left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

//Using DFS - Boolean based recursion by splitting return statement

lass Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null)
            return true;
        //lofic
        if(left == null || right == null || left.val != right.val)
            return false;

        boolean l = helper(left.left, right.right);
        boolean r = helper(left.right, right.left);
        return l && r;
    }
}

//Using BFS Approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }
}

//DFS Iterative Approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Stack <TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        while(!st.isEmpty()){
            TreeNode left = st.pop();
            TreeNode right = st.pop();
        
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            st.push(left.left);
            st.push(right.right);
            
            st.push(left.right);
            st.push(right.left);

        }
        return true;
    }
}