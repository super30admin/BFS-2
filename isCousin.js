// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var isCousins = function(root, x, y) {
    var x_parent, y_parent;
    var x_depth, y_depth;

    dfs(root, null, 0, x, y)
    return x_parent != y_parent && x_depth == y_depth;

    function dfs(root, parent, depth, x, y){
        //base
        if(root == null) return

        //logic
        if(root.val == x){
            x_depth = depth;
            x_parent = parent;   
        }

        if(root.val == y){
            y_depth = depth;
            y_parent = parent;   
        }
        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);
    }
};