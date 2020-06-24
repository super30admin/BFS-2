//After class
// Time Complexity : (O)N
// Space Complexity : (O)h
// Did this code successfully run on Leetcode : yes
// Use recursive dfs appraoch to find parent of x and y and depth of x and y. fincally compare the parent and depth.

class Solution {
    var x_parent: TreeNode? = nil
    var y_parent: TreeNode? = nil
    var x_depth = -1
    var y_depth = -1
    func isCousins(_ root: TreeNode?, _ x: Int, _ y: Int) -> Bool {
       callDepthAndParent(root,0,x,y, nil)
       return x_depth == y_depth && (x_parent !== y_parent)
    }
    
    func callDepthAndParent(_ root: TreeNode?,_ depth: Int, _ x: Int, _ y: Int, _ parent: TreeNode?) {
        //base
         if root == nil {
             return
         }
        //logic
         if root!.val == x {
             x_parent = parent
             x_depth = depth
         }
         if root!.val == y {
             y_parent = parent
             y_depth = depth
         }
        callDepthAndParent(root?.left,depth+1,x,y, root)
        callDepthAndParent(root?.right,depth+1,x,y, root)
    }
}